package com.carRental.entity;

public class Car {
	private long carId;
	private String platNumber;
	private String imagePath;
	private double dailyPrice;
	private CarModel carModel;

	
	public CarModel getCarModel() {
		return carModel;
	}
	public void setCarModel(CarModel carModel) {
		this.carModel = carModel;
	}
	
	public Car() {
		
	}
	public Car(long carId, String platNumber, String imagePath, double dailyPrice) {
		this.carId = carId;
		this.platNumber = platNumber;
		this.imagePath = imagePath;
		this.dailyPrice = dailyPrice;
	}

	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public String getPlatNumber() {
		return platNumber;
	}
	public void setPlatNumber(String plateNumber) {
		this.platNumber = plateNumber;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public double getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	
	

}
