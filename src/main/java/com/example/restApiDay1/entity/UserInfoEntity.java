package com.example.restApiDay1.entity;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfoEntity {
	Random ran=new Random();
	@Id
	private long nameId=ran.nextInt(1000);
	private String name;
	private String country;
	private String state;
	private int phoneNumber;
	@Column(columnDefinition="longblob")
	private byte[] tphoto;
	
	public long getNameId() {
		return nameId;
	}
	public void setNameId(long nameId) {
		this.nameId = nameId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public byte[] getTphoto() {
		return tphoto;
	}
	public void setTphoto(byte[] tphoto) {
		this.tphoto = tphoto;
	}


}
