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
@Table(name = "Product")
public class Product implements Serializable {
	private static final long serialVersionUID = 4361672799947394191L;
	private Integer id;
	private String name;
	private String description;
	private Double price;
	private Integer stock;
	private Category category;
	private Integer personGas;
	private Date createOn;
	private Boolean isDisabled;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoryId",insertable = false, updatable = false)
	public Category getCategory() {
		return category;
	}

	@Column(name = "createOn", nullable = false)
	public Date getCreateOn() {
		return createOn;
	}

	@Column(name = "description", nullable = true)
	public String getDescription() {
		return description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId")
	public Integer getId() {
		return id;
	}

	@Column(name = "isDisabled", nullable = false)
	public Boolean getIsDisabled() {
		return isDisabled;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	@Column(name = "personGas", nullable = false)
	public Integer getPersonGas() {
		return personGas;
	}

	@Column(name = "price", nullable = false)
	public Double getPrice() {
		return price;
	}

	@Column(name = "stock", nullable = false)
	public Integer getStock() {
		return stock;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPersonGas(Integer personGas) {
		this.personGas = personGas;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}