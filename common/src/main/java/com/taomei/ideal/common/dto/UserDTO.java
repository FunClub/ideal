package com.taomei.ideal.common.dto;

import com.taomei.ideal.common.validation.Insert;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/26 10:21 下午
 */
@Data
public class UserDTO {
    private Integer id;

    @NotEmpty(groups = Insert.class)
    private String userName;

    @NotEmpty(groups = Insert.class)
    private String password;
}
