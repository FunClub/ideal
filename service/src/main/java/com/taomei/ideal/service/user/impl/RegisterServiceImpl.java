package com.taomei.ideal.service.user.impl;

import com.taomei.ideal.common.constant.HttpStatusEnum;
import com.taomei.ideal.common.dto.UserDTO;
import com.taomei.ideal.common.exception.BusinessException;
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

    private final UserDao userDao;

    public RegisterServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean register(UserDTO userDTO) throws BusinessException {
        if(userDTO.getId()==null){
            throw new BusinessException( HttpStatusEnum.BUSINESS_ERROR);
        }
        return userDao.insertUser(userDTO) > 0;
    }
}
