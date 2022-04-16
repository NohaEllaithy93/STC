package com.stc.assesment.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Appointments {
	
		
	@Id
	private int id;
	@Column
	private Date appointmentDate;
	@Column
	@JoinColumn(name="id", referencedColumnName="id")
	private Patient paitentId;
	@Column()
	private boolean cancellation_status;
	@Column()
	private String cancellation_reason;
	
	
	public Appointments(int id, Date appointmentDate, Patient paitentId, boolean cancellation_status,
			String cancellation_reason) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.paitentId = paitentId;
		this.cancellation_status = cancellation_status;
		this.cancellation_reason = cancellation_reason;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Patient getPaitentId() {
		return paitentId;
	}
	public void setPaitent_id(Patient paitent_id) {
		this.paitentId = paitentId;
	}
	public boolean isCancellation_status() {
		return cancellation_status;
	}
	public void setCancellation_status(boolean cancellation_status) {
		this.cancellation_status = cancellation_status;
	}
	public String isCancellation_reason() {
		return cancellation_reason;
	}
	public void setCancellation_reason(String cancellation_reason) {
		this.cancellation_reason = cancellation_reason;
	}
	
}
