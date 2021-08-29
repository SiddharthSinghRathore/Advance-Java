<%-- 
    Document   : display2
    Created on : 12-May-2021, 2:03:15 pm
    Author     : siddharthsinghrathour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Display Page</title>
</head>
<body>
<h2>Hello this is a display2.jsp Page</h2>
    UserID: <%=request.getParameter("userid") %><br>
    Password is: <%=request.getParameter("password") %><br>
    Native Location: <%=request.getParameter("location") %><br>
    College: <%=request.getParameter("college") %>
</body>
</html>
