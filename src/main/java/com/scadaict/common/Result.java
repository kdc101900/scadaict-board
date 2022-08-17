package com.scadaict.common;

import lombok.Data;

@Data
public class Result<T> {
	
	private boolean success = true;
	private T result;
	private String message;
	private Integer code = 0;
	private long timestamp = System.currentTimeMillis();
	
	public Result() {
	}
	
	public static<T> Result<T> ok() {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setCode(CommonCode.OK_200);
		return r;
	}
	
	public static<T> Result<T> ok(String msg) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setCode(CommonCode.OK_200);
		r.setResult((T) msg);
		r.setMessage(msg);
		return r;
	}
	
	public static<T> Result<T> ok(T data) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setCode(CommonCode.OK_200);
		r.setResult(data);
		return r;
	}

	public static<T> Result<T> error(String msg) {
		return error(CommonCode.INTERNAL_SERVER_ERROR_500, msg);
	}

	public static<T> Result<T> error(String msg, T data) {
		Result<T> r = new Result<T>();
		r.setSuccess(false);
		r.setCode(CommonCode.INTERNAL_SERVER_ERROR_500);
		r.setMessage(msg);
		r.setResult(data);
		return r;
	}
	
	public static<T> Result<T> error(int code, String msg) {
		Result<T> r = new Result<T>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		return r;
	}
}
