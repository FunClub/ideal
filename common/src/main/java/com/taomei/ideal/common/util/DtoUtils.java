package com.taomei.ideal.common.util;

import org.springframework.beans.BeanUtils;

/**
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/26 10:42 下午
 */
public class DtoUtils {

    public static <T> T copy(Object source, T target){
        BeanUtils.copyProperties(source,target);
        return target;
    }
}
