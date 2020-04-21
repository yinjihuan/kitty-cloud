package com.cxytiandi.kittycloud.aggregation.metadata.impl;

import com.cxytiandi.kittycloud.aggregation.metadata.ApiMetadataService;
import com.cxytiandi.kittycloud.aggregation.request.HttpAggregationRequest;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 22:52
 */
@Service
public class ApiMetadataServiceImpl implements ApiMetadataService {

    @Override
    public HttpAggregationRequest getHttpAggregationRequest(String api) {
        HttpAggregationRequest httpAggregationRequest = new HttpAggregationRequest();

        List<HttpRequest> httpRequests = new ArrayList<>();
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setName("getArticles");
        httpRequest.setUri("http://kitty-cloud-article-provider/articles?page=1&size=10");
        httpRequest.setMethod(HttpMethod.GET.name());
        httpRequests.add(httpRequest);

        httpRequest = new HttpRequest();
        httpRequest.setName("getArticles");
        httpRequest.setUri("http://kitty-cloud-article-provider/articles?page=1&size=10");
        httpRequest.setMethod(HttpMethod.GET.name());
        httpRequests.add(httpRequest);

        httpAggregationRequest.setHttpRequests(httpRequests);
        return httpAggregationRequest;
    }

}