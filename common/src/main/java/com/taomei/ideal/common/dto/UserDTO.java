package com.taomei.ideal.common.dto;

import com.taomei.ideal.common.validation.Insert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * @author 刘滔(2389599310 @ qq.com)
 * @version v1.0
 * @date 2020/9/26 10:21 下午
 */
@Data
@ApiModel(value="UserDTO", description="")
public class UserDTO extends QueryPageDTO {
    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @NotEmpty(groups = Insert.class)
    private String username;

    @ApiModelProperty(value = "密码")
    @NotEmpty(groups = Insert.class)
    private String userPassword;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "生日")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
