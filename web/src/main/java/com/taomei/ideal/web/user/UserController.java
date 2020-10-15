package com.taomei.ideal.web.user;


import com.taomei.ideal.common.dto.UserDTO;
import com.taomei.ideal.common.exception.BusinessException;
import com.taomei.ideal.common.validation.GroupValidated;
import com.taomei.ideal.common.validation.Insert;
import com.taomei.ideal.service.user.RegisterService;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  用户注册控制器
 * </p>
 *
 * @author 刘滔
 * @since 2020-09-26
 */
@RestController
@RequestMapping("/user/")

public class UserController {

    private final RegisterService registerService;

    public UserController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PutMapping
    public Object register(@RequestBody @GroupValidated(Insert.class) UserDTO dto) throws BusinessException {
        return registerService.register(dto);
    }

    @GetMapping
    public Object query(@RequestBody UserDTO userDTO){
        return registerService.query(userDTO);
    }
}

