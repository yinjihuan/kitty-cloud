package com.cxytiandi.kittycloud.common.base;


public enum ResponseCode {
	/** 成功 **/
	SUCCESS_CODE(200, "成功"),
	/** 参数错误 **/
	PARAM_ERROR_CODE(400, "参数错误"),
	/** 禁止访问 **/
	FORBIDDEN(40, "禁止访问"),
	/** 资源不存在 **/
	NOT_FOUND_CODE(404, "资源不存在"),
	/** 不支持的请求方法 **/
	REQUEST_METHOD_NOT_SUPPORTED_CODE(405, "不支持的请求方法"),
	/** 服务器错误 **/
	SERVER_ERROR_CODE(500, "服务器错误"),

	/** 用户服务 **/
	USER_EXCEPTION(10001001, "")
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
