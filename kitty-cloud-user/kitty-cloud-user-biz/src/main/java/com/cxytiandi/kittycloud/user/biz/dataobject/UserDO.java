package com.cxytiandi.kittycloud.user.biz.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cxytiandi.kittycloud.common.base.Entity;
import com.cxytiandi.kittycloud.user.biz.enums.SexEnum;
import com.cxytiandi.kittycloud.user.biz.enums.UserStatusEnum;
import lombok.Data;

/**
 * 用户DO
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Data
@TableName("user")
public class UserDO extends Entity {

    /**
     * 用户ID
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 密码
     */
    private String pass;

    /**
     * 性别
     */
    private SexEnum sex;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 头像地址
     */
    private String headPhotoUrl;

    /**
     * 状态
     */
    private UserStatusEnum status;

}