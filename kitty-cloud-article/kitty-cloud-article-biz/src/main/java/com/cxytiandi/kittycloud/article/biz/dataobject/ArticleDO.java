package com.cxytiandi.kittycloud.article.biz.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cxytiandi.kittycloud.article.biz.enums.ArticleStatusEnum;
import com.cxytiandi.kittycloud.article.biz.enums.ArticleTypeEnum;
import com.cxytiandi.kittycloud.common.base.Entity;
import lombok.Data;

/**
 * 文章DO
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
@Data
public class ArticleDO extends Entity {

    /**
     * 文章ID
     */
    @TableId(type = IdType.ID_WORKER)
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
}