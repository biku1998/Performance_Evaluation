<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String email = String.valueOf(session.getAttribute("email_user"));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Password reset</title>
</head>
<body>
<h1 style="color :#008CBA;">  Your password has been sent to <%=email %> , 
</h1><hr>


<!-- <h3>Click to return to login-page. </h3><hr> -->
  

<a href="login.jsp"><button type="button" id="myBtn"  
  style="background-color: #008CBA;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
"
>Login</button></a>
</body>
</html>
