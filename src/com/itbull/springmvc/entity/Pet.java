package com.itbull.springmvc.entity;

public class Pet {

	private Integer id;
	private String petName;
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Pet [id=" + id + ", petName=" + petName + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	
}
