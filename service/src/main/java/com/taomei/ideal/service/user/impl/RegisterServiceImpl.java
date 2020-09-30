package com.taomei.ideal.service.user.impl;

import com.taomei.ideal.web.dto.UserDto;
import com.taomei.ideal.dao.user.UserDao;
import com.taomei.ideal.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘滔
 * @since 2020-09-26
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean register(UserDto userDTO) {
        boolean b = userDao.insertUser(userDTO) > 0;
        return b;
    }
}
