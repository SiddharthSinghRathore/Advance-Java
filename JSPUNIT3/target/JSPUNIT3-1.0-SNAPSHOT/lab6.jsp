
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <jsp:plugin type="applet" code="lab7.class" codebase="." width="600" height="600">
         
        <jsp:fallback><p>Unable to load applet</p></jsp:fallback>
        </jsp:plugin>
    
</html>
