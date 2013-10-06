package com.bean;

import java.io.Serializable;

import com.entity.Product;

/**
 *购物车商品
 */
public class CartProductBean implements Serializable {
	private static final long serialVersionUID = 3062291660209532032L;
	/**
	 * 商品对象
	 */
	private Product product;
	/**
	 * 数量
	 */
	private Long num;

	public CartProductBean() {

	}

	public CartProductBean(Product pro, Long num) {
		this.product = pro;
		this.num = num;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	/**
	 * 修改数量
	 * 
	 * @param 增加或减少数量
	 * @return
	 */
	public String modifyNum(Long num) {
		if (this.num + num > this.getProduct().getStock()) {
			return "商品库存不够";
		}
		this.num += num;
		return null;
	}

	/**
	 * 获取单个商品总价格
	 */
	public double getPrices() {
		return product.getPrice() * num;
	}
}
