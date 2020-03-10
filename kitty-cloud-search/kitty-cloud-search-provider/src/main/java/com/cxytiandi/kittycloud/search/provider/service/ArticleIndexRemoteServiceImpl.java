package com.cxytiandi.kittycloud.search.provider.service;

import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.common.constant.DubboConstant;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSaveRequest;
import com.cxytiandi.kittycloud.search.api.service.ArticleIndexRemoteService;
import com.cxytiandi.kittycloud.search.biz.service.ArticleIndexService;
import com.cxytiandi.kittycloud.search.provider.convert.ArticleIndexSaveParamConvert;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章索引RPC/REST接口实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 20:40
 */
@Service(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP)
@RestController
public class ArticleIndexRemoteServiceImpl implements ArticleIndexRemoteService {

    @Autowired
    private ArticleIndexService articleIndexService;

    @Autowired
    private ArticleIndexSaveParamConvert articleIndexSaveParamConvert;

    @Override
    public ResponseData<Boolean> saveArticleIndex(ArticleIndexSaveRequest request) {
        Boolean saveResult = articleIndexService.saveArticleIndex(articleIndexSaveParamConvert.convert(request));
        return Response.ok(saveResult);
    }
}