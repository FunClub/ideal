package com.taomei.ideal.dao.user;

import com.baomidou.mybatisplus.extension.service.IService;

import com.taomei.ideal.common.dto.UserDTO;
import com.taomei.ideal.dao.user.entity.UserDO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘滔
 * @since 2020-09-26
 */
public interface UserDao extends IService<UserDO> {

    int insertUser(UserDTO userDto);
}
