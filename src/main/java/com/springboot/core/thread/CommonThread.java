package com.springboot.core.thread;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.springboot.commom.https.HttpUtils;;

/**
 * @author ywc 通用线程
 */

public class CommonThread implements Runnable {
	private static Logger logger = LoggerFactory.getLogger(CommonThread.class);
	private String tip;
	private String url;
	private Map<String, String> paramMap;

	public CommonThread() {

	}

	public CommonThread(String tip, String url, Map<String, String> paramMap) {
		super();
		this.tip = tip;
		this.url = url;
		this.paramMap = paramMap;
	}

	public void run() {
		String reStr = HttpUtils.buildRequest(url, paramMap, 360000, 360000, "UTF-8");
		logger.info(tip + reStr);
	}
}
