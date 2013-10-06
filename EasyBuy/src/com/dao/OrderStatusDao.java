package com.dao;

import java.util.List;

import com.dao.BaseDao;
import com.entity.OrderStatus;

public class OrderStatusDao extends BaseDao<OrderStatus> {

	public List<OrderStatus> findAll() {
		return findAll(OrderStatus.class);
	}

	public OrderStatus find(int id) {
		return null;
	}
}
