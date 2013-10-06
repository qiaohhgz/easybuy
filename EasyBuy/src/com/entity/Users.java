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
@Table(name = "Users")
public class Users implements Serializable {
	private static final long serialVersionUID = -4465272770078879374L;
	private Integer id;
	private String name;
	private String password;
	private String loginName;
	private Date birthday;
	private String email;
	private String phone;
	private String address;
	private Role role;
	private String question;
	private String result;
	private Date createOn;
	private boolean isDisabled;

	@Column(name = "address", nullable = true)
	public String getAddress() {
		return address;
	}

	@Column(name = "birthday", nullable = true)
	public Date getBirthday() {
		return birthday;
	}

	@Column(name = "createOn", nullable = false)
	public Date getCreateOn() {
		return createOn;
	}

	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	public Integer getId() {
		return id;
	}

	@Column(name = "isDisabled", nullable = true)
	public boolean getIsDisabled() {
		return isDisabled;
	}

	@Column(name = "loginName", nullable = false, unique = true)
	public String getLoginName() {
		return loginName;
	}

	@Column(name = "name", nullable = true)
	public String getName() {
		return name;
	}

	@Column(name = "password", nullable = true)
	public String getPassword() {
		return password;
	}

	@Column(name = "phone", nullable = true)
	public String getPhone() {
		return phone;
	}

	@Column(name = "question", nullable = true)
	public String getQuestion() {
		return question;
	}

	@Column(name = "result", nullable = true)
	public String getResult() {
		return result;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleID", insertable = false, updatable = false)
	public Role getRole() {
		return role;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public void setIsDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}