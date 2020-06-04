package com.cxytiandi.kittycloud.article.biz.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxytiandi.kittycloud.article.biz.dao.ArticleDao;
import com.cxytiandi.kittycloud.article.biz.dataobject.ArticleDO;
import com.cxytiandi.kittycloud.article.biz.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 文章DAO实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-11 21:49
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public ArticleDO getById(Long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public IPage<ArticleDO> listHotArticles(int page, int pageSize) {
        QueryWrapper<ArticleDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("heat");

        Page queryPage = new Page<>(page, pageSize);
        return articleMapper.selectPage(queryPage, queryWrapper);
    }

    @Override
    public IPage<ArticleDO> listNewestArticles(int page, int pageSize) {
        QueryWrapper<ArticleDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("add_time");

        Page queryPage = new Page<>(page, pageSize);
        return articleMapper.selectPage(queryPage, queryWrapper);
    }

    @Override
    public IPage<ArticleDO> listArticles(int page, int pageSize) {
        Page queryPage = new Page<>(page, pageSize);
        return articleMapper.selectPage(queryPage, null);
    }
}