package com.taomei.ideal.common.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 数据转换工具
 *
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/22 7:14 下午
 */
@SuppressWarnings("unchecked")
public class DataTranslateUtils {

    /**
     * 将原始对象中的数据拷贝到目标对象
     * @param source 原始对象
     * @param target 目标对象
     * @return 目标对象
     * @author 刘滔(2389599310 @ qq.com)
     * @date 2020/9/22 7:44 下午
     */
    public static <T> T copy(Object source, T target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 原始对象集合生成目标类型的对象集合
     * @param source 原始对象集合
     * @param target 目标对象
     * @return 目标对象集合
     * @author 刘滔(2389599310 @ qq.com)
     * @date 2020/9/22 7:44 下午
     */
    public static <T,E> List<T> copyToList(List<E> source, T target) {
        if (source == null) {
            return new ArrayList<>();
        }
        List<T> targetList = new ArrayList<>();
        source.forEach(e->{
            targetList.add(copy(e,target));
        });
        return targetList;
    }


}
