package com.cxytiandi.kittycloud.gateway.web.controller;

import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Map;

/**
 * Zuul中异常格式返回处理
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-18 14:30:04
 */
@Slf4j
@RestController
public class ErrorHandlerController implements ErrorController {

	@Autowired
	private ErrorAttributes errorAttributes;

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public ResponseData<Object> error(HttpServletRequest request) {
		Map<String, Object> errorAttributes = getErrorAttributes(request);
		String message = (String) errorAttributes.get("message");
		String trace = (String) errorAttributes.get("trace");
		if (StringUtils.hasText(trace)) {
			message += String.format(" and trace %s", trace);
		}
		int status = Integer.parseInt(errorAttributes.get("status").toString());
		if (status == ResponseCode.NOT_FOUND_CODE.getCode()) {
			return Response.fail(message, ResponseCode.NOT_FOUND_CODE);
		}
		log.error(MessageFormat.format("请求发生了非预期异常，出错的 url [{0}]，出错的描述为 [{1}]",
				request.getRequestURL().toString(), message));
		return Response.fail(message, ResponseCode.SERVER_ERROR_CODE);
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
		return errorAttributes.getErrorAttributes(new ServletWebRequest(request), true);
	}

}
