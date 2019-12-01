<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.carRental.entity.Person"%>
<%@page import="com.carRental.repository.signUpRepository"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
if(request.getParameter("confirm") != null){
	String name = request.getParameter("name");
	String surname = request.getParameter("surname");
	
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date fd = formatter.parse(request.getParameter("birthDate"));
	java.sql.Date sqlDate = new java.sql.Date(fd.getTime());
	Date birthDate = sqlDate;
	
	String idNumber = request.getParameter("idNum");
	String email =request.getParameter("email");
	String password = request.getParameter("password");
	Person person = new Person(0 , name , surname , birthDate, idNumber , email , password);
	signUpRepository signUpRepository = new signUpRepository();
	boolean saved = signUpRepository.insert(person);
	
	if(saved == true){
		response.sendRedirect("./LogInPage.jsp");
	}
	
}
%>
<!DOCTYPE html>
<html>
<head>
<link href="testCss.css" type="text/css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
</head>
<body>
<form method="POST">
    <h1 >Rent A Car</h1>
    <h3 >Sign Up Page</h3>
    <p >Please fill form for sign up</p>
    <div>
        <center>
            <fieldset class="fieldset"><br><br>
            <span class="labels">Name :</span> <input type="text" name="name"><br><br>
            <span class="labels">Surname :</span> <input type="text" name="surname"><br><br>
            <span class="labels">Birth Date :</span> <input type="date" name="birthDate" width="25px"><br><br>
            <span class="labels">Id Number :</span> <input type="text" name="idNum"><br><br>
            <span class="labels">E-mail :</span>  <input type="email" name="email"><br><br>
            <span class="labels">Password :</span> <input type="password" name="password" ><br><br><br>
            <input type="submit" name="confirm" value="Confirm" class="buttons">
            <input type="reset" name="Reset" value = "Reset" class="buttons">
            </fieldset>

        </center>
    </div>
</form>

</body>
</html>