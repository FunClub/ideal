package com.taomei.ideal.common.constant;

/**
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/27 1:03 下午
 */
public enum HttpStatusEnum {
    OK(200, "成功"),
    BAD_REQUEST(400, "请求错误"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误")
    ;

    private Integer status;
    private String description;

    HttpStatusEnum() {
    }

    HttpStatusEnum(Integer status, String description) {
        this.status = status;
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
