package com.cxytiandi.kittycloud.article.api.response;

import lombok.Data;

import java.util.List;

/**
 * 文章Response
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@Data
public class ArticleResponse {

    /**
     * 文章ID
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型
     */
    private int type;

    /**
     * 访问次数
     */
    private Long visitCount;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 标签
     */
    private List<String> tags;

    /**
     * 内容（包含HTML）
     */
    private String content;

    /**
     * 文本内容
     */
    private String textContent;

    /**
     * 热度值（点赞数+评论数+访问数）
     */
    private Integer heat;

}