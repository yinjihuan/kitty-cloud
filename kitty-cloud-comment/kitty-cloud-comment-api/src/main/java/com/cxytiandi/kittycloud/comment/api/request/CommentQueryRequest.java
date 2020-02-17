package com.cxytiandi.kittycloud.comment.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-16 15:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentQueryRequest implements Serializable {

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

}