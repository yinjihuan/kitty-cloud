package com.cxytiandi.kittycloud.article.api.response;

import lombok.Data;

import java.util.List;

/**
 * 文章信息
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
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
     * 用户名
     */
    private String username;

    /**
     * 标签
     */
    private List<String> tags;

    /**
     * 内容（包含HTML）
     */
    private String content;

    /**
     * 热度值（点赞数+评论数+访问数）
     */
    private Integer heat;

}