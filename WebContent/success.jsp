<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" com.techpalle.util.SuccesPage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>

<%
     SuccesPage  spJSP= (SuccesPage)request.getAttribute("succesDetails");

%>
<header>
<h1>
<%= spJSP.h1 %> </h1>
</header>



<p><%= spJSP.p %></p>


<footer>
<h3> <%= spJSP.h3 %> </h3>
</footer>
</body>
</html>