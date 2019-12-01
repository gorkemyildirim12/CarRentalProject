<%@page import="com.carRental.entity.CarRent"%>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.carRental.repository.CarRentRepository"%>
<%@page import="com.carRental.entity.CarModel"%>
<%@page import="com.carRental.repository.CarModelRepository"%>
<%@page import="com.carRental.entity.Car"%>
<%@page import="java.util.List"%>
<%@page import="com.carRental.repository.CarRepository"%>
<%@page import="com.carRental.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String email = (String)session.getAttribute("email");
    	String message = "";
    	if(email == null ){
    		response.sendRedirect("./LogInPage.jsp");
    		return;
    	}
    	CarRepository carRepository = new CarRepository();
    	List<Car> carList = carRepository.list();
    	
    	
    	if(request.getParameter("rent") != null){
    		long carId = Long.parseLong(request.getParameter("carId"));
    		Car car = carRepository.find(carId);
    		
    		DateFormat formattersd = new SimpleDateFormat("yyyy-MM-dd");
    		Date sd = formattersd.parse(request.getParameter("startDate"));
    		java.sql.Date sqlDatesd = new java.sql.Date(sd.getTime());
    		Date startDate = sqlDatesd;
    		
    		DateFormat formattered = new SimpleDateFormat("yyyy-MM-dd");
    		Date ed = formattered.parse(request.getParameter("endDate"));
    		java.sql.Date sqlDateed = new java.sql.Date(ed.getTime());
    		Date endDate = sqlDateed;
    		
    
    		int rentDay = (int)(endDate.getTime()-startDate.getTime()) / (1000 * 60 * 60 * 24);
    		double totalAmount = car.getDailyPrice()*rentDay;
    		CarRent carRent = new CarRent(0 , startDate , endDate ,totalAmount);
    		
    		CarRentRepository carRentRepository = new CarRentRepository();
    		boolean saved = carRentRepository.insert(carRent);
    		
    		if(saved){
    			response.sendRedirect("CarRented.jsp");	
    		}else{
    			message = "Something went wrong";
    		}
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<link href="MainPageCss.css" type="text/css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Alatsi&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Alatsi|Calistoga&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Rent Your Car</title>
</head>
<body>
<h1>Hosgeldiniz <%=email %></h1>
<%=message%>
<table allign="center">

	<tr>
	<td><h2><i>Select A Car</i></h2></td>
	</tr>
	
		<%for(Car car:carList){%>
		<tr>
		<form method="POST">
			<input type ="hidden" name = "carId" value="<%=car.getCarId()%>"/>
			<td>
			<%=car.getCarModel().getModelName() %><br>
			<img src = "<%=car.getImagePath()%>" alt = "<%=car.getCarId()%>" width="325" height =250/>
			</td>
			<td>
			 	<p>Start Date : </p><input type="date" name="startDate"><br><br>
    			<p>End Date   :</p><input type="date" name="endDate">
			</td>
			
			<td>
			<br><br>
			Daily Price is <%=car.getDailyPrice() %> TL
			<input type="submit" name="rent" value="Rent This Car"/>
			</td>
			
		</form>
		</tr>
	<% }%>
</table>
</body>
</html>