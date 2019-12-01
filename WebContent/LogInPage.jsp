<%@page import="java.util.ArrayList"%>
<%@page import="com.carRental.entity.Person"%>
<%@page import="java.util.List"%>
<%@page import="com.carRental.repository.signUpRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
   String message ="";
   if(request.getParameter("login") != null){
	   String email = request.getParameter("email");
	   String password = request.getParameter("password");
	    
	   signUpRepository signUpRepository = new signUpRepository();
	   boolean authenticated = signUpRepository.authentication(email , password);
	   
	   
	   if(authenticated){
		   	session.setAttribute("email", email);
		  	response.sendRedirect("./MainPage.jsp");
		  	return;
		}
		else{
		   message = "Wrong email or password";
	   }	   
   }
   %>
<!DOCTYPE html>
<html>
<head>
<link href="LogInPageCss.css" type="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<img src="LogInPage.png" class="image_bmw">
	<center>
		<h1>Login Page</h1>
		<%=message %>
		<form method="POST">
			<fieldset>
			
				E mail: <input type="email" name="email"><br><br> 
				Password : <input type="password" name="password"><br><br> 
				<input type="submit" name="login" value="Login" class="buttons"><br>
				<br> If you dont have an account please <a href="http://localhost:8080/carRentalProject/SignUpPage.jsp">Sign Up</a>
			</fieldset>
		</form>

	</center>

</body>
</html>