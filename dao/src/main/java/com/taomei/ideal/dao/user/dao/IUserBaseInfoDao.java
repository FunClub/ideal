package com.taomei.ideal.dao.user.dao;

import com.github.pagehelper.PageInfo;
import com.taomei.ideal.common.dto.UserDTO;
import com.taomei.ideal.dao.user.entity.UserBaseInfoDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘滔
 * @since 2020-10-04
 */
public interface IUserBaseInfoDao{


    boolean insert(UserDTO userDTO);

    PageInfo<UserDTO> queryPage(UserDTO userDTO);
}
