package com.carRental.entity;

import java.util.Date;

public class CarRent {
	private long rentId;
	private Date startDate;
	private Date endDate;
	private boolean rentStatus;
	private double totalAmount;

	
	
	public long getRentId() {
		return rentId;
	}
	public void setRentId(long rentId) {
		this.rentId = rentId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isRentStatus() {
		return rentStatus;
	}
	public void setRentStatus(boolean rentStatus) {
		this.rentStatus = rentStatus;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public CarRent(long rentId, Date startDate, Date endDate, double totalAmount) {
		this.rentId = rentId;
		this.startDate = startDate;
		this.endDate = endDate;
		
		this.totalAmount = totalAmount;
	}
	
	public CarRent() {
		// TODO Auto-generated constructor stub
	}

}
