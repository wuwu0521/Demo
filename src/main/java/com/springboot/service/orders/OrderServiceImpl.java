package com.springboot.service.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.core.db.DataSource;
import com.springboot.dao.silverwaimai.WaimaiMapper;
import com.springboot.entity.silverwaimai.Waimai;

@Service
@DataSource(name=DataSource.DATASOURCE_B)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private WaimaiMapper waimaiMapper;
	
	@Override
	public Waimai getOrderInfo(Long id) {
		return waimaiMapper.selectByPrimaryKey(id); 
	}

}
