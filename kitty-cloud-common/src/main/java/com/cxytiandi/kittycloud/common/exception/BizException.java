package com.cxytiandi.kittycloud.common.exception;


import com.cxytiandi.kittycloud.common.base.ResponseCode;

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
