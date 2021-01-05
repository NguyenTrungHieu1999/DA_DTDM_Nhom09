package com.hcmute.model;

public class Student {

	private String Id;	
	private String FullName;
	private String Gender;
	private String Birthdate;
	private String Address;
	private String Phone;
	private Boolean IsDelete;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		this.FullName = fullName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public String getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.Birthdate = birthdate;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		this.Phone = phone;
	}

	public Boolean getIsDelete() {
		return IsDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.IsDelete = isDelete;
	}


	@Override
	public String toString() {
		return "Student [Id=" + Id + ", FullName=" + FullName + ", Gender=" + Gender +", Birthdate=" + Birthdate +", Address="+ Address +", Phone="+ Phone +"]";
	}

}