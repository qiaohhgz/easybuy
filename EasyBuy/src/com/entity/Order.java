package com.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "Order")
public class Order implements Serializable {
	private static final long serialVersionUID = 7005508658159457386L;
	private Integer id;
	private String number;
	private Users user;
	private String userName;
	private String userAddress;
	private Double cost;
	private OrderStatus status;
	private BuyType type;
	private Date createOn;
	private boolean isDisabled;

	@Column(name = "cost")
	public Double getCost() {
		return cost;
	}

	@Column(name = "createOn", nullable = false)
	public Date getCreateOn() {
		return createOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	public Integer getId() {
		return id;
	}

	@Column(name = "isDisabled", nullable = false)
	public boolean getIsDisabled() {
		return isDisabled;
	}

	@Column(name = "number", nullable = false)
	public String getNumber() {
		return number;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderStatusId", nullable = false, insertable = false, updatable = false)
	public OrderStatus getStatus() {
		return status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buyTypeId", nullable = false, insertable = false, updatable = false)
	public BuyType getType() {
		return type;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usersId", nullable = false, insertable = false, updatable = false)
	public Users getUser() {
		return user;
	}

	@Column(name = "userAddress", nullable = false)
	public String getUserAddress() {
		return userAddress;
	}

	@Column(name = "userName", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIsDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void setType(BuyType type) {
		this.type = type;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}