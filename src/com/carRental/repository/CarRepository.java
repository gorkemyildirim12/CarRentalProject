package com.carRental.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.carRental.entity.Car;
import com.carRental.entity.CarModel;

public class CarRepository extends BaseRepository{
	public List<Car> list() throws Exception{
		connect();
		
		List<Car> carList = new ArrayList<Car>();
		String sql = "select * from car left join car_model_info on car.modelId=car_model_info.modelId;";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			long carId = resultSet.getLong("carId");
			String platNumber = resultSet.getString("platNumber");
			String imagePath = resultSet.getString("imagePath");
			double dailyPrice = resultSet.getDouble("dailyPrice");
			long modelId = resultSet.getLong("modelId");
			String modelName = resultSet.getString("modelName");
			int modelYear = resultSet.getInt("modelYear");
			CarModel carModel = new CarModel(modelId , modelName , modelYear);
			Car car = new Car(carId, platNumber, imagePath, dailyPrice);
			car.setCarModel(carModel);
			carList.add(car);
		}
		
		disconnect();
		return carList;
	}
	public Car find(long carId) throws Exception{
		Car car = new Car();
		connect();
		String sql = "select * from car where carId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, carId);
		ResultSet resultSet =statement.executeQuery();
		if(resultSet.next()) {
			String platNumber = resultSet.getString("platNumber");
			String imagePath = resultSet.getString("imagePath");
			double dailyPrice = resultSet.getDouble("dailyPrice");
			car = new Car(carId, platNumber, imagePath, dailyPrice);
		}
		disconnect();
		return car;
	}
}
