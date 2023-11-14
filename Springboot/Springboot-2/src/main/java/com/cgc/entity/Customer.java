package com.cgc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerAuto")

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="cname")
	private String cname;
	@Column(name="city")
	private String city;
	@Column(name="phoneNumber")
	private Long phoneNumber;
	public Customer(Long id, String cname, String city, Long phoneNumber) {
		super();
		this.id = id;
		this.cname = cname;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	public Customer() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", cname=" + cname + ", city=" + city + ", phoneNumber=" + phoneNumber + "]";
	}

}
