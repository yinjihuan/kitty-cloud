package com.cxytiandi.kittycloud.article.biz.service.impl;

import com.cxytiandi.kittycloud.article.biz.bo.ArticleBO;
import com.cxytiandi.kittycloud.article.biz.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章业务接口实现
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Override
    public ArticleBO getArticle(int articleId) {
        return null;
    }

    @Override
    public List<ArticleBO> listHotArticles(int page, int pageSize) {
        return null;
    }

    @Override
    public List<ArticleBO> listNewestArticles(int page, int pageSize) {
        return null;
    }

}