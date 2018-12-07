package com.springboot.core.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.springboot.core.CoreResponse;
import com.springboot.core.CoreResponse.StatusInfo;

/**
 * 网关统一异常错误处理
 * 
 * @description
 * @author cjx
 * @date 2018年5月8日
 */
@Controller
@ResponseBody
public class ErrorHandlerController extends AbstractErrorController {
	private final static Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);

	public ErrorHandlerController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param outRequestNo
	 * @return
	 */
	@RequestMapping("/error")
	public CoreResponse<Map<String, Object>> error(HttpServletRequest request, HttpServletResponse response) {
		CoreResponse<Map<String, Object>> res = new CoreResponse<>(StatusInfo.BUSINESS);
		// 错误消息体，不重写该方法，默认就是返回该消息体
		Map<String, Object> errorbody = this.getErrorAttributes(request, this.getTraceParameter(request));
		res.setData(errorbody);
		logger.error("【调用接口异常】{}", JSONObject.toJSONString(res.getData()));
		return res;
	}
}
