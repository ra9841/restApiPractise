package com.example.restApiDay1.dto;

import org.springframework.web.multipart.MultipartFile;

public class UerInfoDto {
	private long nameId;
	private String name;
	private String country;
	private String state;
	private int phoneNumber;
	private MultipartFile file;
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public byte[] getTphoto() {
		return tphoto;
	}
	public void setTphoto(byte[] tphoto) {
		this.tphoto = tphoto;
	}
	

}
