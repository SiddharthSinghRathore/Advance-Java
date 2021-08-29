<%-- 
    Document   : AppletJSP
    Created on : May 11, 2021, 10:54:32 PM
    Author     : mnpem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Applet JSP</title>
    </head>
    <body>
        <jsp:plugin align="middle" height="500" width="500"  
     type="applet"  code="AppletExample.class" name="clock" codebase=".">
            
        </jsp:plugin>
    </body>
</html>
