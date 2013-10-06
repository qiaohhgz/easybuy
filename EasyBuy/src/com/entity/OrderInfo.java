package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderInfo")
public class OrderInfo implements Serializable {
	private static final long serialVersionUID = 1234364452749691248L;
	private Integer id;
	private Order order;
	private Product product;
	private Integer quantity;
	private Double totalPrice;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderInfoId")
	public Integer getId() {
		return id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId",insertable = false, updatable = false)
	public Order getOrder() {
		return order;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId",insertable = false, updatable = false)
	public Product getProduct() {
		return product;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}

	@Column(name = "totalPrice")
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}