package com.cxytiandi.kittycloud.search.api.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 23:47
 */
@Data
public class ArticleIndexSaveRequest implements Serializable {

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
     * 用户ID
     */
    private Long userId;

    /**
     * 标签
     */
    private List<String> tags;

    /**
     * 文本内容
     */
    private String textContent;

    /**
     * 文章状态
     */
    private int status;

    /**
     * 热度值（点赞数+评论数+访问数）
     */
    private Integer heat;

}