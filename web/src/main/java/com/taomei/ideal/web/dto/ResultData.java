package com.taomei.ideal.web.dto;

import lombok.Data;

/**
 * 相应给客户端的统一数据
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/27 12:50 下午
 */
@Data
public class ResultData {
    private Integer status;
    private Object data;
    private String message;
}
