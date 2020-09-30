package com.taomei.ideal.common.util;

/**
 * 字符串工具类
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/26 3:20 下午
 */
public class StringUtils {

    public static boolean isEmpty(String str){
        if(str==null){
            return true;
        }
        return str.length() == 0;
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

}
