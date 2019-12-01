package com.carRental.entity;


import java.util.Date;

public class CarModel {
	private long modelId;
	private String modelName;
	private int modelYear;
	
	public CarModel() {
		// TODO Auto-generated constructor stub
	}
	
	public CarModel(long modelId, String modelName, int modelYear) {
		this.modelId = modelId;
		this.modelName = modelName;
		this.modelYear = modelYear;
	}

	public long getModelId() {
		return modelId;
	}
	public void setModelId(long modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	
	
}
