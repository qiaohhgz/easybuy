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
@Table(name = "Category")
public class Category implements Serializable {
	private static final long serialVersionUID = -1036024034327633589L;
	private Integer id;
	private String name;
	private Category categoryFather;
	private Date createOn;
	private boolean isDisabled;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryFatherId", referencedColumnName = "categoryId")
	public Category getCategoryFather() {
		return categoryFather;
	}

	@Column(name = "createOn", nullable = false)
	public Date getCreateOn() {
		return createOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryId", unique = true, nullable = false)
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

	public void setCategoryFather(Category categoryFather) {
		this.categoryFather = categoryFather;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIsDisabled(boolean disabled) {
		this.isDisabled = disabled;
	}

	public void setName(String name) {
		this.name = name;
	}
}