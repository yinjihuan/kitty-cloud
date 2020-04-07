package com.cxytiandi.kittycloud.common.base;

/**
 * REST API 响应码
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
public enum ResponseCode {
	SUCCESS_CODE(200, "成功"),
	PARAM_ERROR_CODE(400, "参数错误"),
	FORBIDDEN_CODE(403, "禁止访问"),
	NOT_FOUND_CODE(404, "资源不存在"),
	REQUEST_METHOD_NOT_SUPPORTED_CODE(405, "不支持的请求方法"),
	SERVER_LIMIT_CODE(429, "服务限流"),
	SERVER_ERROR_CODE(500, "服务器错误"),
	SERVER_DOWNGRADE_CODE(700, "服务降级"),
	TOKEN_TIMEOUT_CODE(800, "登录信息过期"),


	/**
	 * 用户服务
	 * 前三位 100
	 * 中两位 01 通用异常 02 登录业务
	 * 后三位 具体错误
	 */
	USER_EXCEPTION_CODE(10001001, "用户通用异常"),
	USER_LOGIN_ERROR_CODE(10002001, "用户名或密码错误")
	;



	private int code;
	private String message;

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	private ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
