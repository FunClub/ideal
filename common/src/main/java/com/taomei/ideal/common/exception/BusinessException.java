package com.taomei.ideal.common.exception;

import com.taomei.ideal.common.constant.HttpStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/30 9:11 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends Exception {
    //状态码
    private Integer status;
    public BusinessException(String message,Integer status) {
        super(message);
        this.status = status;
    }

    public BusinessException(HttpStatusEnum statusEnum) {
        super(statusEnum.getDescription());
        this.status = statusEnum.getStatus();
    }

}
