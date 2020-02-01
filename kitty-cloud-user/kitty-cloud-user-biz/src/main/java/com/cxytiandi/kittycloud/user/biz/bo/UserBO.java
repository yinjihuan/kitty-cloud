package com.cxytiandi.kittycloud.user.biz.bo;

import com.cxytiandi.kittycloud.user.biz.enums.SexEnum;
import com.cxytiandi.kittycloud.user.biz.enums.UserStatusEnum;
import lombok.Data;

/**
 * @author: yinjihuan
 * @create: 2020-01-09 17:10
 */
@Data
public class UserBO {

    /**
     * 用户ID
     */
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