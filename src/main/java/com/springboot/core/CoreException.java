package com.springboot.core;

import org.springframework.util.StringUtils;

/**
 * 异常类简单封装
 * 在调用dubbo时候，接口是需要做预处理，返回调用者
 * 信息。可以是状态码方式，当那样会增加发开和文档成本，使用
 * 简单异常，调用者可统一异常处理，返回业务处理失败。
 * 将不友好的异常信息转换成友好的信息给调用者
 * @author YTGHTGHS
 * @date 2017年12月3日
 * @description
 */
public class CoreException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4175993706957876165L;

	private String message;
	private CoreExceptionCode code;

	public CoreException() {
		super();
	}

	public CoreException(CoreExceptionCode code) {
		super(code.getName());
		this.code = code;
		this.message = code.getName();
		
	}
	
	public CoreException(String message, CoreExceptionCode code) {
		if (StringUtils.isEmpty(message)) {
			this.message = code.getName();
		} else {
			this.message = message;
		}
		this.code = code;
	}
	
	public CoreException(CoreExceptionCode code, Throwable cause) {
		super(code.getName(), cause);
		this.code = code;
		this.message = code.getName();
	}

	public CoreException(String message, CoreExceptionCode code, Throwable cause) {
		super(message, cause);
		if (StringUtils.isEmpty(message)) {
			this.message = code.getName();
		} else {
			this.message = message;
		}
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CoreExceptionCode getCode() {
		return code;
	}

	public void setCode(CoreExceptionCode code) {
		this.code = code;
	}

	public static enum CoreExceptionCode {

		// 必须参数为空检测
		EXCP_PARAM_NULL("some parameters can not be empty"),
		// 日期格式化转换错误
		EXCP_DATE_FORMAT("date format error"),
		// SQL执行错误
		EXCP_SQL_ERROR("sql may be wrong"),
		// SQL执行错误
		EXCP_OTHERS("others may be wrong");

		private String name;

		public String getName() {

			return name;

		}

		public void setName(String name) {
			this.name = name;
		}

		private CoreExceptionCode(String name) {
			this.name = name;
		}
	}

}
