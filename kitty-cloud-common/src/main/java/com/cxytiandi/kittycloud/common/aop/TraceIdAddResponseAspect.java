package com.cxytiandi.kittycloud.common.aop;

import brave.Tracer;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Trace ID 添加到响应内容中切面
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-07 11:09
 */
@Aspect
public class TraceIdAddResponseAspect {

    @Autowired
    private Tracer tracer;

    @Around("execution(public * com.cxytiandi.kittycloud..provider.service..*(..)))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object result = pjp.proceed();
            if (result instanceof ResponseData && tracer != null) {
                String traceId = tracer.currentSpan().context().traceIdString();
                ResponseData responseData = (ResponseData)result;
                responseData.setRequestId(traceId);
            }
            return result;
        } catch (Throwable throwable) {
            throw throwable;
        }
    }

}