<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Customer Regestration Form</h1>

<form action="regCustomer" method="post">

Name:<input type="text" name="tbName" id="tbName">     <br><br>

Email:<input type="text" name="tbEmail" id="tbEmail">     <br><br>

Mobile:<input type="tel" name="tbMobile" id="tbMobile">     <br><br>

password:<input type="password" name="tbPass" id="tbPass">     <br><br>

state: <select name="ddlStates">
<option value="">states</option>
<option value="Karnataka">KA</option>
<option value="Tamilnadu">TN</option>
<option value="AndhraPradesh">AP</option>
<option value="Kerala">KL</option>
<option value="Telangana">TS</option>
</select>

<br><br>
<input type="submit" value="Register">
   
</form>
</body>
</html>