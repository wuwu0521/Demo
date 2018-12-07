package com.springboot.controller.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.entity.silverwaimai.Waimai;
import com.springboot.service.orders.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("order")
@Api(tags = { "订单接口" })
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value="/getOrderInfo")
	@ResponseBody
	@ApiOperation(value = "获取订单信息")
	public Waimai getOrderInfo(Long id) {
		Waimai waimai = orderService.getOrderInfo(id);
		return waimai;
	}
}
