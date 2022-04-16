package com.stc.assesment.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Cancelation_Reasons {
	
	
	public Cancelation_Reasons(int id, String reason) {
		super();
		this.id = id;
		this.reason = reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Column
	private int id;
	@Column
	private String reason;

}
