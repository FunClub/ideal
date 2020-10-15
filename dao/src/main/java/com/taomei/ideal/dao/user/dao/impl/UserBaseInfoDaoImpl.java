package com.taomei.ideal.dao.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.taomei.ideal.common.dto.UserDTO;
import com.taomei.ideal.dao.util.DataTranslateUtils;
import com.taomei.ideal.dao.user.dao.IUserBaseInfoDao;
import com.taomei.ideal.dao.user.entity.UserBaseInfoDO;
import com.taomei.ideal.dao.user.mapper.UserBaseInfoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘滔
 * @since 2020-10-04
 */
@Repository
public class UserBaseInfoDaoImpl extends ServiceImpl<UserBaseInfoMapper, UserBaseInfoDO> implements IUserBaseInfoDao {

    private final UserBaseInfoMapper mapper;

    public UserBaseInfoDaoImpl(UserBaseInfoMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public boolean insert(UserDTO userDTO) {
        return this.save(DataTranslateUtils.copy(userDTO,new UserBaseInfoDO()));
    }

    @Override
    public PageInfo<UserDTO> queryPage(UserDTO userDTO) {
        UserBaseInfoDO userDO = DataTranslateUtils.copy(userDTO,new UserBaseInfoDO());
        List<UserBaseInfoDO> list = this.list(new QueryWrapper<>(userDO));
        return DataTranslateUtils.copyToPageInfo(list,new UserDTO());
    }


}
