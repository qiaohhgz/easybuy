package com.bean;

import java.io.Serializable;

import com.entity.Product;

/**
 *���ﳵ��Ʒ
 */
public class CartProductBean implements Serializable {
	private static final long serialVersionUID = 3062291660209532032L;
	/**
	 * ��Ʒ����
	 */
	private Product product;
	/**
	 * ����
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
	 * �޸�����
	 * 
	 * @param ���ӻ��������
	 * @return
	 */
	public String modifyNum(Long num) {
		if (this.num + num > this.getProduct().getStock()) {
			return "��Ʒ��治��";
		}
		this.num += num;
		return null;
	}

	/**
	 * ��ȡ������Ʒ�ܼ۸�
	 */
	public double getPrices() {
		return product.getPrice() * num;
	}
}
