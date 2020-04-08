package com.cxytiandi.kittycloud.gateway.web.filter;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import com.cxytiandi.kitty.common.json.JsonUtils;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.helper.JWTHelper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 用户认证过滤器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-06 23:11
 */
@Slf4j
@Component
public class UserAuthFilter extends ZuulFilter {

    /**
     * API白名单，在网关不需要验证直接放行
     */
    @Value("${kitty.cloud.gateway.whiteapis:}")
    private List<String> whiteApis = Arrays.asList();

    /**
     * 用户登出的Token存储
     */
    @CreateCache(name="logoutCache:")
    private Cache<String, Long> logoutCache;

    @Autowired
    private JWTHelper jwtHelper;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_ERROR_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("请求进来了");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        String token = request.getHeader("token");
        // API白名单内直接放行
        if (whiteApis.contains(uri)) {
            return null;
        }

        // 不在白名单中则进行Token验证
        if (StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(JsonUtils.toJson(Response.fail("非法请求【缺少token】", ResponseCode.FORBIDDEN_CODE)));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }

        // 验证Token是否有效
        JWTHelper.JWTResult jwResult = jwtHelper.checkToken(token);
        if (!jwResult.isStatus()) {
            ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(JsonUtils.toJson(Response.fail(jwResult.getMsg(), jwResult.getCode())));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }

        // 此token已经注销
        Long cacheResult = logoutCache.get(token);
        if (cacheResult != null) {
            ctx.setSendZuulResponse(false);
            ctx.set("isSuccess", false);
            ctx.setResponseBody(JsonUtils.toJson(Response.fail("非法请求", ResponseCode.FORBIDDEN_CODE)));
            ctx.getResponse().setContentType("application/json; charset=utf-8");
            return null;
        }
        ctx.addZuulRequestHeader("kittyCloudUserId", jwResult.getUid());
        return null;
    }
}