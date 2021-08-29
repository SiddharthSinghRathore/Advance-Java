<%-- 
    Document   : SessionAttributes
    Created on : 12-May-2021, 12:23:11 pm
    Author     : siddharthsinghrathour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session ="true" %>

<!DOCTYPE html>

<html>
<head>
<title>JSP session attribute</title>
</head>
<body>


<h2>Creating a session</h2>   <br/>

Session ID : <%= session.getId() %>   <br/>

Session creation time : <%= new Date(session.getCreationTime()) %>

</body>

</html>