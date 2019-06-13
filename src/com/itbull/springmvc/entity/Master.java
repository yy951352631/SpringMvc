package com.itbull.springmvc.entity;

public class Master {

	private Integer id;
	private String masterName;
	private Pet pet;
	public Master() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	@Override
	public String toString() {
		return "Master [id=" + id + ", masterName=" + masterName + ", pet="
				+ pet + "]";
	}
	
	
}
