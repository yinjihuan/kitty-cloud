package com.cxytiandi.kittycloud.search.biz.service.impl;

import com.cxytiandi.kitty.cat.annotation.CatTransaction;
import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.search.biz.bo.ArticleIndexBO;
import com.cxytiandi.kittycloud.search.biz.convert.ArticleDocumentConvert;
import com.cxytiandi.kittycloud.search.biz.convert.ArticleIndexBOConvert;
import com.cxytiandi.kittycloud.search.biz.dao.ArticleIndexDao;
import com.cxytiandi.kittycloud.search.biz.document.ArticleDocument;
import com.cxytiandi.kittycloud.search.biz.param.ArticleIndexSaveParam;
import com.cxytiandi.kittycloud.search.biz.param.ArticleIndexSearchParam;
import com.cxytiandi.kittycloud.search.biz.service.ArticleIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private ArticleIndexBOConvert articleIndexBOConvert;

    @Override
    public Boolean saveArticleIndex(ArticleIndexSaveParam param) {
        return articleIndexDao.saveArticleIndex(articleDocumentConvert.convert(param));
    }

    @CatTransaction
    @Override
    public Page<ArticleIndexBO> searchArticleIndex(ArticleIndexSearchParam param) {
        Page<ArticleDocument> articleDocumentPage = articleIndexDao.searchArticleIndex(param);
        List<ArticleIndexBO> articleIndexBOList = articleDocumentPage.getList().stream().map(articleIndexBOConvert::convert).collect(Collectors.toList());
        return new Page<>(articleDocumentPage.getStart(), articleDocumentPage.getLimit(), articleIndexBOList, articleDocumentPage.getTotalRecords());
    }
}