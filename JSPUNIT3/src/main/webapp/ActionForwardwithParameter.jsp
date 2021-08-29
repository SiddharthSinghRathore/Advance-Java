<%-- 
    Document   : ActionForwardwithParameter
    Created on : 12-May-2021, 1:30:45 pm
    Author     : siddharthsinghrathour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<title>JSP forward example with parameters</title>
</head>
<body> 
    <jsp:forward page="display1.jsp"> 
        <jsp:param name="name" value="<b>Siddharth Singh Rathore</b>" /> 
        <jsp:param name="subject" value="<b>EAP</b>" /> 
        <jsp:param name="action" value="<b>jsp forward action tag</b>" /> 
        <jsp:param name="reqcamefrom" value="<b>ActionForwardwithParameter.jsp</b>" /> 
    </jsp:forward> 
</body> 
</html>