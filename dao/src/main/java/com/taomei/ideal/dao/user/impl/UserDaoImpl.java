package com.taomei.ideal.dao.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taomei.ideal.web.dto.UserDto;
import com.taomei.ideal.common.util.DtoUtils;
import com.taomei.ideal.dao.user.UserDao;
import com.taomei.ideal.dao.user.entity.UserDO;
import com.taomei.ideal.dao.user.mapper.UserMapper;
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
public class UserDaoImpl extends ServiceImpl<UserMapper, UserDO> implements UserDao {
    public UserDaoImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    private UserMapper userMapper;

    @Override
    public int insertUser(UserDto userDto) {
        return userMapper.insert(DtoUtils.copy(userDto,new UserDO()));
    }
}
