package com.springboot.core;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 公共核心返回类封装
 * @author YTGHTGHS
 * @date 2017年12月27日
 * @description 
 * @param <T>
 */
public class CoreResponse<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6068250409891922171L;

	private String code;//具体错误码
	
	private String msg;//业务错误
	
	private String subMsg;//具体业务错误
	
	private T data;//具体返回对象
	
	@JSONField(serialize=false)  
	@JsonIgnore
	private StatusInfo statusInfo;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getSubMsg() {
		return subMsg;
	}

	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public StatusInfo getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(StatusInfo statusInfo) {
		this.statusInfo = statusInfo;
		this.code = statusInfo.getCode();
		this.msg = statusInfo.getMessage();
	}

	public CoreResponse(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public CoreResponse() {
		this.setStatusInfo(StatusInfo.SUCCESS);
	}

	public CoreResponse(StatusInfo statusInfo) {
		this.setStatusInfo(statusInfo);
	}


	public static enum StatusInfo {

		SUCCESS("10000", "OK"),

		ONLY_READ("20001", "只有查看权限，无写权限"),
		//权限拦截，无权限时的异常
		UNAUTHORIZED("20002", "无权限进行此操作，请跟管理员联系"),
		//请求的参数不对，比如修改用户名，没有传入用户id
		ERROR_40001("40001", "缺少必选参数"),
		ERROR_40002("40002", "非法的参数"),
		//未登录异常
		NOSESSION("40003", "未登录，请先登录"),
		//不合法的业务请求，比如直接删除管理有很多用户的用户组
		FORBIDDEN("40004", "业务处理失败，请检查请求参数"),
		//所有内部异常，统一如此相应
		BUSINESS("40005", "服务器忙，请稍后再次尝试，或者跟管理员联系"),

		//鉴权失败
		//AUTHORIZE_FAILED(405, "权限验证失败"),

		//操作的资源不存在，比如 /user/{id}的增删查改等操作请求
		NORESOURCE("40010", "请求的资源不存在");

		final private  String code;
		final private  String message;

		private StatusInfo(String code, String message) {
			this.code = code;
			this.message = message;
		}

		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

	}
}
