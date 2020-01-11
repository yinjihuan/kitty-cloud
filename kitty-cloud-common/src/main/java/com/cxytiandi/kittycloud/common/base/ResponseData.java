package com.cxytiandi.kittycloud.common.base;

import java.util.ArrayList;
import java.util.List;

/**
 * REST API 返回数据格式类
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 *
 */
public class ResponseData<T> {
	private int code = 200;
	private String message = "";
	private T data;
	private String domain;
	private List<Error> errors;

	public boolean isSuccess() {
		if(this.code == ResponseCode.SUCCESS_CODE.getCode()){
			return true;
		}
		return false;
	}
	
	public ResponseData<T> ok(T data) {
		this.data = data;
		return this;
	}

	public ResponseData<T> ok(T data, String message) {
		this.data = data;
		this.message = message;
		return this;
	}

	public ResponseData<T> fail() {
		this.code = ResponseCode.SERVER_ERROR_CODE.getCode();
		return this;
	}

	public ResponseData<T> fail(String message) {
		this.code = ResponseCode.SERVER_ERROR_CODE.getCode();
		this.message = message;
		return this;
	}

	public ResponseData<T> fail(String message, ResponseCode code) {
		this.message = message;
		this.code = code.getCode();
		return this;
	}

	public ResponseData<T> fail(String message, ResponseCode code, String domain) {
		this.message = message;
		this.code = code.getCode();
		this.domain = domain;
		return this;
	}

	public ResponseData<T> fail(String message, int code) {
		this.message = message;
		this.code = code;
		return this;
	}

	public ResponseData(T data) {
		super();
		this.data = data;
	}

	public ResponseData(String message) {
		super();
		this.message = message;
	}

	public ResponseData(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}

	public ResponseData() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDomain() {
		return domain;
	}

	public void addError(String name, String message) {
		if (this.errors == null) {
			this.errors = new ArrayList<Error>();
		}
		this.errors.add(new Error(name + "\t" + message));
	}

}
