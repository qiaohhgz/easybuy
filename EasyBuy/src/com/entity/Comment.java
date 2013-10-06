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
@Table(name = "Comment")
public class Comment implements Serializable {
	private static final long serialVersionUID = 6438965654556131162L;
	private Integer id;
	private Product product;
	private String content;
	private Users user;
	private Date createOn;
	private boolean isDisabled;

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	@Column(name = "createOn", nullable = false)
	public Date getCreateOn() {
		return createOn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentId")
	public Integer getId() {
		return id;
	}

	@Column(name = "isDisabled", nullable = false)
	public boolean getIsDisabled() {
		return isDisabled;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	public Product getProduct() {
		return product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usersId", insertable = false, updatable = false)
	public Users getUser() {
		return user;
	}

	public void setContent(String content) {
		this.content = content;
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

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}