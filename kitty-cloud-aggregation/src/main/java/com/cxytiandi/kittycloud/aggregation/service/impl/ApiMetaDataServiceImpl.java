package com.cxytiandi.kittycloud.aggregation.service.impl;

import com.cxytiandi.kittycloud.aggregation.service.ApiMetaDataService;
import com.cxytiandi.kittycloud.aggregation.request.HttpAggregationRequest;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * API 元数据业务接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 22:52
 */
@Service
public class ApiMetaDataServiceImpl implements ApiMetaDataService {

    @Override
    public HttpAggregationRequest getHttpAggregationRequest(String api) {
        HttpAggregationRequest httpAggregationRequest = new HttpAggregationRequest();

        List<HttpRequest> httpRequests = new ArrayList<>();
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setName("getArticles");
        httpRequest.setUri("http://kitty-cloud-article-provider/articles");
        httpRequest.setMethod(HttpMethod.GET.name());
        httpRequest.setParams("{\"page\":\"$request.page\",\"size\":\"$request.size\"}");
        httpRequests.add(httpRequest);

        httpRequest = new HttpRequest();
        httpRequest.setName("getUsers");
        httpRequest.setUri("http://kitty-cloud-user-provider/users/{id}");
        httpRequest.setMethod(HttpMethod.GET.name());
        httpRequest.setParams("{\"id\":\"getArticles#data.articleResp.list.userId\"}");
        httpRequest.setRef("getArticles");
        httpRequests.add(httpRequest);

        httpAggregationRequest.setHttpRequests(httpRequests);
        return httpAggregationRequest;
    }

}