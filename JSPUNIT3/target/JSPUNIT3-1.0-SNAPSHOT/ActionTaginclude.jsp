<%-- 
    Document   : ActionTaginclude
    Created on : 12-May-2021, 1:55:02 pm
    Author     : siddharthsinghrathour
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<title>JSP Include example with parameters</title>
</head>
<body> 
<h2>This is ActionTaginclude.jsp Page</h2>
    <jsp:include page="display2.jsp"> 
    <jsp:param name="userid" value="<b>Siddharth</b>" /> 
    <jsp:param name="password" value="<b>Rathore</b>" /> 
    <jsp:param name="location" value="<b>ARA</b>" /> 
    <jsp:param name="college" value="<b>R.V.C.E</b>" /> 
    </jsp:include> 
</body> 
</html>