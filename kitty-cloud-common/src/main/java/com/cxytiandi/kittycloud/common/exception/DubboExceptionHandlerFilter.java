package com.cxytiandi.kittycloud.common.exception;

import brave.Tracer;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.helper.ApplicationContextHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.text.MessageFormat;

/**
 * Dubbo 服务端异常处理
 * 
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-08 14:42
 */
@Slf4j
@Activate(group = {CommonConstants.PROVIDER}, order = Integer.MAX_VALUE)
public class DubboExceptionHandlerFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = null;
        try {
            result = invoker.invoke(invocation);
            if (result != null && result.getException() instanceof BizException) {
                BizException bizException = (BizException) result.getException();
                result.setValue(Response.fail(getDomain(), bizException.getMessage(), getTraceId(), bizException.getCode()));
            } else {
                result.setValue(Response.fail(getDomain(), result.getException().getMessage(), getTraceId(), ResponseCode.SERVER_ERROR_CODE));
            }
        } catch (RuntimeException e) {
            log.error(MessageFormat.format("请求发生了非预期异常，出错的 url [{0}]，出错的描述为 [{1}]",
                    invoker.getUrl().toFullString(), e.getMessage()), e);
            result.setValue(Response.fail(getDomain(), e.getMessage(), getTraceId(), ResponseCode.SERVER_ERROR_CODE));
        }

        // 这边将异常移除掉是为了不让Dubbo底层对异常进行处理，否则就不能返回固定的格式给调用方
        result.setException(null);
        return result;
    }

    private String getDomain() {
        String domain = ApplicationContextHelper.getEnvironment().getProperty("spring.application.name");
        return domain;
    }

    private String getTraceId() {
        Tracer tracer = ApplicationContextHelper.getBean(Tracer.class);
        String traceId = "";
        if (tracer.currentSpan() != null) {
            traceId = tracer.currentSpan().context().traceIdString();
        }
        return traceId;
    }

}