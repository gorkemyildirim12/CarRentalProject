package com.carRental.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.carRental.entity.CarModel;

public class CarModelRepository extends BaseRepository{
	public List<CarModel> list() throws Exception{
		List<CarModel> carModelList = new ArrayList<CarModel>();
		connect();
		String sql = "select * from car_model_info ";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			long modelId = resultSet.getLong("modelId");
			String modelName = resultSet.getString("modelName");
			int modelYear = resultSet.getInt("modelYear");
			CarModel carModel = new CarModel(modelId, modelName, modelYear);
			carModelList.add(carModel);
		}
		disconnect();
		return carModelList;
	}
	public CarModel find(long modelId) throws Exception{
		CarModel carModel = new CarModel();
		connect();
		String sql = "select * from car_model_info where modelId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, modelId);
		ResultSet resultSet =statement.executeQuery();
		if(resultSet.next()) {
			String modelName = resultSet.getString("modelName");
			int modelYear = resultSet.getInt("modelYear");
			carModel = new CarModel(modelId, modelName, modelYear);
		}
		disconnect();
		return carModel;
	}
	
}
