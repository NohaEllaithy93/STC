package com.stc.assesment.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Patient {
	
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private int mobNum;
	
	
	public Patient(int id, String name, int mobNum) {
		super();
		this.id = id;
		this.name = name;
		this.mobNum = mobNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobNum() {
		return mobNum;
	}
	public void setMobNum(int mobNum) {
		this.mobNum = mobNum;
	}

}
