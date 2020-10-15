package com.taomei.ideal.web.aspect;

import com.taomei.ideal.common.constant.HttpStatusEnum;
import com.taomei.ideal.common.validation.GroupValidated;
import com.taomei.ideal.common.dto.ResultData;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


/*
 * 统一处理切面
 * @author 刘滔(2389599310@qq.com)
 * @date 2020/9/21 2:37 下午
 * @version v1.0
 */
@Aspect
@Component
@SuppressWarnings("unchecked")
public class CommonAspect {
    private Logger logger;

    // 异常处理和数据封装的连接点
    @Pointcut("execution(* com.taomei.ideal.web.*.*Controller.*(..))")
    public void exceptionHandleAndDataEncapsulation() {
    }

    /**
     * 处理器方法的参数校验、日志输出、异常处理及返回数据的封装
     * 最好在控制器方法上指定@ApiOperation增加可读性，这样可以在日志中看到操作名，而不是控制器方法名
     *
     * @param joinPoint 连接点
     * @return 响应给前台的统一数据
     * @author 刘滔(2389599310 @ qq.com)
     * @date 2020/9/21 3:26 下午
     */
    @Around(value = "exceptionHandleAndDataEncapsulation()")
    public ResultData exceptionHandleAndDataEncapsulation(ProceedingJoinPoint joinPoint) {

        //***日志输出***
        Object targetObject = joinPoint.getTarget();
        logger = LoggerFactory.getLogger(CommonAspect.class);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object[] argsValues = joinPoint.getArgs();
        MethodSignature methodSignature = ((MethodSignature) joinPoint.getSignature());
        Method targetMethod = methodSignature.getMethod();
        String[] parameterNames = methodSignature.getParameterNames();
        ApiOperation apiOperation = targetMethod.getAnnotation(ApiOperation.class);
        String methodOperation = null;

        if (apiOperation != null) {
            StringBuilder sb = new StringBuilder();
            methodOperation = apiOperation.value();
            sb.append("开始执行【").append(methodOperation).append("】,");
            for (String parameterName : parameterNames) {
                sb.append(parameterName).append("={}, ");
            }
            logger.info(sb.toString(), argsValues);
        } else {
            //没有给控制器指定@ApiOperation
            methodOperation = targetMethod.getName();
            logger.info("开始执行【" + methodOperation + "】, param={}", argsValues);
        }

        //***控制器参数参数校验***
        Parameter[] parameters = targetMethod.getParameters();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        StringBuilder paramSB = new StringBuilder();
        Class<?>[] groups;
        for (int i = 0; i < parameters.length; i++) {
            Annotation[] annotations = parameters[i].getDeclaredAnnotations();
            for (int j = 0; j < annotations.length; j++) {
                if (annotations[j] instanceof GroupValidated) {//分组验证
                    groups = ((GroupValidated) annotations[j]).value();
                    validator.validate(argsValues[i], groups)
                            .forEach(f -> paramSB.append(f.getPropertyPath()).append(f.getMessage()).append(","));
                }else {//默认验证
                    validator.validate(argsValues[i])
                            .forEach(f -> paramSB.append(f.getPropertyPath()).append(f.getMessage()).append(","));
                }
            }
        }

        Object result;
        ResultData view = new ResultData();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        //参数不合法
        if (!paramSB.toString().isEmpty()) {
            paramSB.deleteCharAt(paramSB.lastIndexOf(","));
            view.setMessage(paramSB.toString());
            view.setStatus(HttpStatusEnum.BAD_REQUEST.getStatus());
            response.setStatus(HttpStatusEnum.BAD_REQUEST.getStatus());
            logger.error("执行【" + methodOperation + "】失败, 原因：参数不合法");
            return view;
        }

        //***进行处理器方法调用***
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {//调用失败
            view.setMessage(HttpStatusEnum.INTERNAL_SERVER_ERROR.getDescription());
            view.setStatus(HttpStatusEnum.INTERNAL_SERVER_ERROR.getStatus());
            response.setStatus(HttpStatusEnum.INTERNAL_SERVER_ERROR.getStatus());
            logger.error("失败执行【" + methodOperation + "】, 原因：" + throwable.getMessage());
            throwable.printStackTrace();
            return view;
        }
        view.setData(result);
        view.setMessage(HttpStatusEnum.OK.getDescription());
        view.setStatus(HttpStatusEnum.OK.getStatus());
        stopWatch.stop();
        logger.info("成功执行【" + methodOperation + "】, 耗时：" + stopWatch.getTotalTimeSeconds() + "秒");

        return view;
    }

    //分页服务连接点
    @Pointcut("execution(* com.taomei.ideal.web..*.*Page(..))")
    public void pagingService() {
    }
}
