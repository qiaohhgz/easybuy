package com.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * 购物车
 */
public class CartBean implements Serializable {
	private static final long serialVersionUID = 3729048938982022590L;
	/**
	 * 购物车商品集合
	 */
	private Map<Long, CartProductBean> map = new HashMap<Long, CartProductBean>();

	/**
	 * 增加商品
	 * 
	 * @param 商品编号
	 * @param 商品对象
	 */
	public String addCartProduct(Long id, CartProductBean pro) {
		try {
			map.put(id, pro);
		} catch (Exception e) {
			return "增加商品失败";
		}
		return null;
	}

	/**
	 * 删除商品
	 * 
	 * @param id
	 */
	public void delCartProduct(Long id) {
		map.remove(id);
	}

	/**
	 * 获得所有商品集合
	 * 
	 * @return
	 */
	public Collection<CartProductBean> fillAll() {
		return map.values();
	}

	/**
	 * 获取总价
	 * 
	 * @return
	 */
	public double getTotalPrice() {
		Collection<CartProductBean> cPros = map.values();
		double price = 0;
		for (CartProductBean cp : cPros) {
			price += cp.getPrices();
		}
		return price;
	}

	/**
	 * 修改商品
	 * 
	 * @param 商品编号
	 * @param 商品数量
	 */
	public String modifyCartProduct(Long id, Long num) {
		try {
			CartProductBean cPro = map.get(id);
			return cPro.modifyNum(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
