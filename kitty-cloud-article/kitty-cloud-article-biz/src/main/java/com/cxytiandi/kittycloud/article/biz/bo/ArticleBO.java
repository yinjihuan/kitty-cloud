package com.cxytiandi.kittycloud.article.biz.bo;

import com.cxytiandi.kittycloud.article.biz.enums.ArticleStatusEnum;
import com.cxytiandi.kittycloud.article.biz.enums.ArticleTypeEnum;
import lombok.Data;

/**
 * @author: yinjihuan
 * @create: 2020-01-19 13:17
 */
@Data
public class ArticleBO {

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
    private ArticleTypeEnum type;

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
     * 标签（多个英文逗号分隔）
     */
    private String tags;

    /**
     * 内容（包含HTML）
     */
    private String content;

    /**
     * 文本内容
     */
    private String textContent;

    /**
     * 文章状态
     */
    private ArticleStatusEnum status;

    /**
     * 热度值（点赞数+评论数+访问数）
     */
    private Integer heat;
}