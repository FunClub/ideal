package com.taomei.ideal.service.user;

import com.taomei.ideal.web.dto.UserDto;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘滔
 * @since 2020-09-26
 */
public interface RegisterService{

    boolean register(UserDto userDTO);
}
