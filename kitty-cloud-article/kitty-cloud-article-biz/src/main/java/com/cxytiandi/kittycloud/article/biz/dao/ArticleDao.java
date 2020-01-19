package com.cxytiandi.kittycloud.article.biz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxytiandi.kittycloud.article.biz.dataobject.ArticleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao extends BaseMapper<ArticleDO> {

}
