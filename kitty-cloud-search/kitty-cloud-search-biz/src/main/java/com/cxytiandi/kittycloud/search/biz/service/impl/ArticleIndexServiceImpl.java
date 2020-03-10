package com.cxytiandi.kittycloud.search.biz.service.impl;

import com.cxytiandi.kittycloud.search.biz.convert.ArticleDocumentConvert;
import com.cxytiandi.kittycloud.search.biz.dao.ArticleIndexDao;
import com.cxytiandi.kittycloud.search.biz.param.ArticleIndexSaveParam;
import com.cxytiandi.kittycloud.search.biz.service.ArticleIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 21:13
 */
@Service
public class ArticleIndexServiceImpl implements ArticleIndexService {

    @Autowired
    private ArticleIndexDao articleIndexDao;

    @Autowired
    private ArticleDocumentConvert articleDocumentConvert;

    @Override
    public Boolean saveArticleIndex(ArticleIndexSaveParam param) {
        return articleIndexDao.saveArticleIndex(articleDocumentConvert.convert(param));
    }
}