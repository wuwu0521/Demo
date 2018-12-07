package com.springboot.service.orders;

import com.springboot.entity.silverwaimai.Waimai;

public interface OrderService {
	
	Waimai getOrderInfo(Long id);
}
