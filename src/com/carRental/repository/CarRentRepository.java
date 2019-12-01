package com.carRental.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.carRental.entity.CarRent;
import java.sql.Date;

public class CarRentRepository extends BaseRepository{
	public boolean insert(CarRent carRent) throws Exception{
		connect();
		String sql = "insert into car_rent(rentId , startDate , endDate , totalAmount) values(? , ? , ? , ? )";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, carRent.getRentId());
		statement.setDate(2, (Date)carRent.getStartDate());
		statement.setDate(3, (Date)carRent.getEndDate());
		statement.setDouble(4, carRent.getTotalAmount());
		
		int affected = statement.executeUpdate();
		disconnect();
		
		return affected > 0;
	}
	public CarRent find(long rentId) throws Exception{
		CarRent carRent = new CarRent();
		connect();
		String sql = "select * from  car_ rent where rentId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, rentId);
		ResultSet resultSet =statement.executeQuery();
		if(resultSet.next()) {
			Date startDate = resultSet.getDate("startDate");
			Date endDate = resultSet.getDate("endDate");
			double totalAmount = resultSet.getDouble("totalAmount");
			carRent = new CarRent(rentId, startDate, endDate, totalAmount);
		}
		disconnect();
		return carRent;
	}
}
