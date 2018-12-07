package com.springboot.core.thread;

import java.util.Map;

import com.springboot.commom.https.HttpUtils;

/**
 * http异步调用，无返回值调用
 * 
 * @author YTGHTGHS
 * @date 2018年1月18日
 * @description
 */
public class HttpThread implements Runnable {
	
	private String url;
	
	private Map<String, String> paramMap;

	public HttpThread(String url, Map<String, String> paramMap) {
		super();
		this.url = url;
		this.paramMap = paramMap;
	}

	@Override
	public void run() {
		HttpUtils.doPostForm(url, paramMap);		
	}
}
