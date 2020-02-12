package com.cxytiandi.kittycloud.article.biz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxytiandi.kittycloud.article.biz.dataobject.ArticleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章DAO
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@Mapper
public interface ArticleDao extends BaseMapper<ArticleDO> {

}
