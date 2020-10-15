package com.taomei.ideal.service.user.impl;

import com.github.pagehelper.PageInfo;
import com.taomei.ideal.common.constant.HttpStatusEnum;
import com.taomei.ideal.common.dto.UserDTO;
import com.taomei.ideal.common.exception.BusinessException;
import com.taomei.ideal.dao.user.dao.IUserBaseInfoDao;
import com.taomei.ideal.service.user.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final IUserBaseInfoDao userBaseInfoDao;

    public RegisterServiceImpl(IUserBaseInfoDao userBaseInfoDaoImpl) {
        this.userBaseInfoDao = userBaseInfoDaoImpl;
    }

    @Override
    public boolean register(UserDTO userDTO) throws BusinessException {

        return userBaseInfoDao.insert(userDTO);
    }

    @Override
    public PageInfo<UserDTO> query(UserDTO userDTO) {
        return userBaseInfoDao.queryPage(userDTO);
    }

}
