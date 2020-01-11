package com.cxytiandi.kittycloud.common.exception;

import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.text.MessageFormat;

/**
 * 全局异常处理
 * 
 * @author yinjihuan
 * 
 * @about http://cxytiandi.com/about
 *
 *
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@Value("${spring.application.domain:${spring.application.name:unknown}}")
	private String domain;

	/**
	 * 针对业务异常的处理
	 *
	 * @param exception 业务异常
	 * @param request   http request
	 * @return 异常处理结果
	 */
	@ExceptionHandler(value = BizException.class)
	public ResponseData bizException(BizException exception,
									 HttpServletRequest request) {
		log.warn("请求发生了预期异常，出错的 url [{}]，出错的描述为 [{}]",
				request.getRequestURL().toString(), exception.getMessage());
		return Response.fail(domain, exception.getMessage(), exception.getCode());
	}

	/**
	 * 针对参数校验失败异常的处理
	 *
	 * @param exception 参数校验异常
	 * @param request   http request
	 * @return 异常处理结果
	 */
	@ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class, ConstraintViolationException.class})
	public ResponseData databindException(Exception exception, HttpServletRequest request) {
		log.error(MessageFormat.format("请求发生了非预期异常，出错的 url [{0}]，出错的描述为 [{1}]",
				request.getRequestURL().toString(), exception.getMessage()), exception);
		ResponseData result = new ResponseData();
		result.setDomain(domain);
		result.setCode(ResponseCode.PARAM_ERROR_CODE.getCode());
		result.setMessage(ResponseCode.PARAM_ERROR_CODE.getMessage());

		if (exception instanceof BindException) {
			for (FieldError fieldError : ((BindException) exception).getBindingResult().getFieldErrors()) {
				result.addError(fieldError.getField(), fieldError.getDefaultMessage());
			}
		} else if (exception instanceof MethodArgumentNotValidException) {
			for (FieldError fieldError : ((MethodArgumentNotValidException) exception).getBindingResult().getFieldErrors()) {
				result.addError(fieldError.getField(), fieldError.getDefaultMessage());
			}
		} else if (exception instanceof ConstraintViolationException) {
			for (ConstraintViolation cv : ((ConstraintViolationException) exception).getConstraintViolations()) {
				result.addError(cv.getPropertyPath().toString(), cv.getMessage());
			}
		}
		return result;
	}

	/**
	 * 针对spring web 中的异常的处理
	 *
	 * @param exception Spring Web 异常
	 * @param request   http request
	 * @return 异常处理结果
	 */
	@ExceptionHandler(value = {
			NoHandlerFoundException.class,
			HttpRequestMethodNotSupportedException.class,
			HttpMediaTypeNotSupportedException.class
	})
	public ResponseData springWebExceptionHandler(Exception exception, HttpServletRequest request) {
		log.error(MessageFormat.format("请求发生了非预期异常，出错的 url [{0}]，出错的描述为 [{1}]",
				request.getRequestURL().toString(), exception.getMessage()), exception);
		if (exception instanceof NoHandlerFoundException) {
			return Response.fail(domain, exception.getMessage(), ResponseCode.NOT_FOUND_CODE);
		} else if (exception instanceof HttpRequestMethodNotSupportedException) {
			return Response.fail(domain, exception.getMessage(), ResponseCode.REQUEST_METHOD_NOT_SUPPORTED_CODE);
		}
		return Response.fail(domain, exception.getMessage(), ResponseCode.SERVER_ERROR_CODE);
	}

	/**
	 * 针对全局异常的处理
	 *
	 * @param exception 全局异常
	 * @param request   http request
	 * @return 异常处理结果
	 */
	@ExceptionHandler(value = Throwable.class)
	public ResponseData throwableHandler(Exception exception, HttpServletRequest request) {
		log.error(MessageFormat.format("请求发生了非预期异常，出错的 url [{0}]，出错的描述为 [{1}]",
				request.getRequestURL().toString(), exception.getMessage()), exception);
		return Response.fail(domain, exception.getMessage(), ResponseCode.SERVER_ERROR_CODE);
	}

}
