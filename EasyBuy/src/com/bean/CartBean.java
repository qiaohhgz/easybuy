package com.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * ���ﳵ
 */
public class CartBean implements Serializable {
	private static final long serialVersionUID = 3729048938982022590L;
	/**
	 * ���ﳵ��Ʒ����
	 */
	private Map<Long, CartProductBean> map = new HashMap<Long, CartProductBean>();

	/**
	 * ������Ʒ
	 * 
	 * @param ��Ʒ���
	 * @param ��Ʒ����
	 */
	public String addCartProduct(Long id, CartProductBean pro) {
		try {
			map.put(id, pro);
		} catch (Exception e) {
			return "������Ʒʧ��";
		}
		return null;
	}

	/**
	 * ɾ����Ʒ
	 * 
	 * @param id
	 */
	public void delCartProduct(Long id) {
		map.remove(id);
	}

	/**
	 * ���������Ʒ����
	 * 
	 * @return
	 */
	public Collection<CartProductBean> fillAll() {
		return map.values();
	}

	/**
	 * ��ȡ�ܼ�
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
	 * �޸���Ʒ
	 * 
	 * @param ��Ʒ���
	 * @param ��Ʒ����
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
