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
@Table(name = "Role")
public class Role implements Serializable {
	private static final long serialVersionUID = 7465013911007473677L;
	private Integer id;
	private String name;
	private String description;
	private Date createOn;
	private boolean isDisabled;

	@Column(name = "createOn", nullable = false)
	public Date getCreateOn() {
		return createOn;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roleId")
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

	public void setDescription(String description) {
		this.description = description;
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
