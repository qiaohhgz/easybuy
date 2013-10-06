package com.dao;

import java.util.List;

import com.dao.BaseDao;
import com.entity.OrderInfo;

public class OrderInfoDao extends BaseDao<OrderInfo> {

	public List<OrderInfo> findAll() {
		return findAll(OrderInfo.class);
	}

	public OrderInfo find(int id) {
		return null;
	}
}
