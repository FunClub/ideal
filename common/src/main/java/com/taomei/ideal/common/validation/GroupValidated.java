package com.taomei.ideal.common.validation;

import javax.validation.Valid;
import java.lang.annotation.*;

/**
 * 分组验证标识
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/30 5:23 下午
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GroupValidated {
    Class<?>[] value() default {};
}
