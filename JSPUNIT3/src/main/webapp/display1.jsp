<%-- 
    Document   : display1
    Created on : 12-May-2021, 1:31:57 pm
    Author     : siddharthsinghrathour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Display Page</title>
</head>
<body>
<h2>Hello this is a display1.jsp Page</h2>
    My name is: <%=request.getParameter("name") %><br>
    Subject: <%=request.getParameter("subject") %><br>
    Topic: <%=request.getParameter("action") %><br>
    Forward Request came from the page: <%=request.getParameter("reqcamefrom") %>
</body>
</html>