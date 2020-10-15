package com.taomei.ideal.dao.aspect;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taomei.ideal.common.dto.QueryPageDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

@Component
@Aspect
public class DaoAspect {
    private Logger logger = LoggerFactory.getLogger(DaoAspect.class);

    @Around("execution(* com.taomei.ideal.dao.*.dao.*Dao.*Page(..))")
    public Object paging(ProceedingJoinPoint joinPoint){
        logger.error("调用【分页服务的统一处理】");
        Object[] args = joinPoint.getArgs();
        QueryPageDTO queryPage = (QueryPageDTO) args[0];
        PageHelper.startPage(queryPage.getPageNumber(), queryPage.getPageSize());
        PageInfo<Object> pageInfo = null;
        try {
            pageInfo = (PageInfo<Object>) joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("调用【分页服务的统一处理】失败，原因："+throwable.getMessage());
            throwable.printStackTrace();
        }finally {
            PageHelper.clearPage();
        }
        if(pageInfo==null){
            pageInfo = new PageInfo<>();
        }
        return pageInfo;
    }
}
