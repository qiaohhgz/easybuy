package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderStatus")
public class OrderStatus implements Serializable {

	private static final long serialVersionUID = 6934961006024348843L;

	private Integer id;
	private String name;
	private Date createOn;
	private boolean isDisabled;

	@Column(name = "createOn", nullable = false)
	public Date getCreateOn() {
		return createOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderStatusId")
	public Integer getId() {
		return id;
	}

	@Column(name = "isDisabled", nullable = false)
	public boolean getIsDisabled() {
		return isDisabled;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
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

	public void setName(String name) {
		this.name = name;
	}

}
