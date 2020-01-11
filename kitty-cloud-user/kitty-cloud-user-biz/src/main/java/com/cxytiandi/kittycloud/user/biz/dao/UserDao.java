package com.cxytiandi.kittycloud.user.biz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxytiandi.kittycloud.user.biz.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserDO> {

}
