package com.cxytiandi.kittycloud.comment.biz.param;

import com.github.structlog4j.IToLog;
import lombok.Data;

/**
 * 评论查询参数
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-16 15:12
 */
@Data
public class CommentQueryParam implements IToLog {

    /**
     * 评论业务类型
     */
    private int commentBizType;

    /**
     * 评论业务ID
     */
    private String commentBizId;

    /**
     * 页数
     */
    private int page;

    /**
     * 页大小
     */
    private int pageSize;

    @Override
    public Object[] toLog() {
        return new Object[] {
                "commentBizType", commentBizType,
                "commentBizId", commentBizId,
                "page", page,
                "pageSize", pageSize
        };
    }
}