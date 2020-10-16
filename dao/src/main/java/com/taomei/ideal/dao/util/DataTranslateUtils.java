package com.taomei.ideal.dao.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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
     * 将com.github.pagehelper.Page拷贝生成类型为E的PageInfo
     * @param sourcePage 数据来源
     * @return target 目标类型
     * @author 刘滔(2389599310@qq.com)
     * @date 2020/10/16 8:23 上午
     */
    public static <T, E> PageInfo<E> copyToPageInfo(List<T> sourcePage, E target){
        if(sourcePage instanceof Page){
            Page<E> targetPage = new Page<>();
            //拷贝分页信息
            copy(sourcePage,targetPage);
            //拷贝集合元素
            List<E> targetList = copyToList(sourcePage, target);
            PageInfo<E> pageInfo = new PageInfo<>(targetPage);
            pageInfo.setList(targetList);
            return pageInfo;
        }
        return new PageInfo<>();
    }

    /**
     * 将原始对象中的数据拷贝到目标对象
     *
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
     *
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
