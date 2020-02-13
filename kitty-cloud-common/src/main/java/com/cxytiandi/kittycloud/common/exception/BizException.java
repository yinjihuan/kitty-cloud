package com.cxytiandi.kittycloud.common.exception;


import com.cxytiandi.kittycloud.common.base.ResponseCode;

/**
 * 自定义业务异常
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
public class BizException extends RuntimeException {
	
	private static final long serialVersionUID = -5701182284190108797L;
	
	private ResponseCode code;

	public void setCode(ResponseCode code) {
		this.code = code;
	}

	public ResponseCode getCode() {
		return code;
	}

	public BizException(String message) {
		super(message);
	}

	public BizException(ResponseCode code) {
		super(code.getMessage());
		this.code = code;
	}

	public BizException(ResponseCode code, String message) {
		super(message);
		this.code = code;
	}

}
