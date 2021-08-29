
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<title>
JSP info attribute
</title>

</head>


<body>

<%@ page  info ="It is an online portal An online portal that provides 
easy tutorials of Java programming language." %>

<h2>Information about JSP page</h2>

<%= getServletInfo() %> <br/>

</body>
