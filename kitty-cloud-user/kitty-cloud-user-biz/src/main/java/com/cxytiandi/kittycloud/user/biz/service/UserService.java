package com.cxytiandi.kittycloud.user.biz.service;

import com.cxytiandi.kittycloud.user.biz.bo.UserBO;

public interface UserService {

    /**
     * 获取用户
     * @param id
     * @return
     */
    UserBO getUser(Long id);

}
