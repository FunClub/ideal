package com.taomei.ideal.web.user;


import com.taomei.ideal.common.exception.BusinessException;
import com.taomei.ideal.common.validation.GroupValidated;
import com.taomei.ideal.common.validation.Insert;
import com.taomei.ideal.common.dto.UserDTO;
import com.taomei.ideal.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 *  用户注册控制器
 * </p>
 *
 * @author 刘滔
 * @since 2020-09-26
 */
@RestController
@RequestMapping("/user/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public Object register(@GroupValidated(Insert.class) UserDTO dto) throws BusinessException {
        return registerService.register(dto);
    }
}

