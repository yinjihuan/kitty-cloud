package com.cxytiandi.kittycloud.common.base;

/**
 * REST API 返回数据工具类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
public class Response {

	private Response() {}
	
	public static <E> ResponseData<E> ok() {
		ResponseData<E> res = new ResponseData<E>();
		res.ok(null);
		return res;
	}
	
	public static <E> ResponseData<E> ok(E data) {
		ResponseData<E> res = new ResponseData<E>();
		res.ok(data);
		return res;
	}
	
	public static <E> ResponseData<E> ok(E data, String message) {
		ResponseData<E> res = new ResponseData<E>();
		res.ok(data, message);
		return res;
	}
	
	public static <E> ResponseData<E> fail(String message) {
		ResponseData<E> res = new ResponseData<E>();
		res.fail(message);
		return res;
	}
	
	public static <E> ResponseData<E> failByParams(String message) {
		ResponseData<E> res = new ResponseData<E>();
		res.fail(message);
		res.setCode(ResponseCode.PARAM_ERROR_CODE.getCode());
		return res;
	}
	
	public static <E> ResponseData<E> fail(String message, ResponseCode code) {
		ResponseData<E> res = new ResponseData<E>();
		res.fail(message, code);
		return res;
	}

	public static <E> ResponseData<E> fail(String domain, String message, ResponseCode code) {
		ResponseData<E> res = new ResponseData<E>();
		res.fail(message, code, domain);
		return res;
	}

	public static <E> ResponseData<E> fail(String message, int code) {
		ResponseData<E> res = new ResponseData<E>();
		res.fail(message, code);
		return res;
	}
	
}
