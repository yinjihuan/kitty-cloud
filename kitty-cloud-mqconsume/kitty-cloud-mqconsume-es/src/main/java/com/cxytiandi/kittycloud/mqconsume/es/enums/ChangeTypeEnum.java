package com.cxytiandi.kittycloud.mqconsume.es.enums;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-29 23:09
 */
public enum ChangeTypeEnum {

    /**
     * 新增
     */
    INSERT(1, "新增"),
    /**
     * 修改
     */
    UPDATE(2, "修改"),

    /**
     * 删除
     */
    DELETE(3, "删除");

    ChangeTypeEnum(int type, String descp) {
        this.type = type;
        this.descp = descp;
    }

    /**
     * 类型
     */
    private int type;

    /**
     * 描述
     */
    private String descp;

    public int getType() {
        return type;
    }

    public String getDescp() {
        return descp;
    }

    public static ChangeTypeEnum from(int type) {
        for (ChangeTypeEnum changeType: ChangeTypeEnum.values()) {
            if (changeType.getType() == type) {
                return changeType;
            }
        }
        return null;
    }

}