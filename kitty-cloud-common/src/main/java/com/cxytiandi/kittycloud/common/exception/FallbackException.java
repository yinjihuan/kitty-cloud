package com.cxytiandi.kittycloud.common.exception;


import com.cxytiandi.kittycloud.common.base.ResponseCode;

/**
 * 自定义降级异常
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-27 20:44:04
 */
public class FallbackException extends RuntimeException {

	private ResponseCode code = ResponseCode.SERVER_DOWNGRADE_CODE;

	public ResponseCode getCode() {
		return code;
	}

	public FallbackException(String message) {
		super(message);
	}

	public FallbackException() {
		this.code = code;
	}

}
