package com.example.restApiDay1.response;

import java.util.Objects;

public class ClientUserInfoResponseDto {
	private String name;
	private String country;
	private String state;
	private int phoneNumber;
	private String username;
	private String roll;
	public String getName() {
		return name;
	}
	/*
	 * @Override public int hashCode() { return Objects.hash(country, name,
	 * phoneNumber, roll, state, username); }
	 */

	/*
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; ClientUserInfoResponseDto other = (ClientUserInfoResponseDto) obj;
	 * return Objects.equals(country, other.country) && Objects.equals(name,
	 * other.name) && phoneNumber == other.phoneNumber && Objects.equals(roll,
	 * other.roll) && Objects.equals(state, other.state) && Objects.equals(username,
	 * other.username); }
	 */
	@Override
	public String toString() {
		return "ClientUserInfoResponseDto [name=" + name + ", country=" + country + ", state=" + state
				+ ", phoneNumber=" + phoneNumber + ", username=" + username + ", roll=" + roll + "]";
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	
	
	


}
