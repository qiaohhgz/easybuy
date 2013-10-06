package com.dao;

import java.util.List;

import com.dao.BaseDao;
import com.entity.Order;

public class OrderDao extends BaseDao<Order> {

	public List<Order> findAll() {
		return findAll(Order.class);
	}

	public Order find(int id) {
		return null;
	}
}
