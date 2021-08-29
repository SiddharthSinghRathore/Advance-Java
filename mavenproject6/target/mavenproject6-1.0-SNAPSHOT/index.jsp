 <%-- 
    Document   : index
    Created on : 27-May-2021, 8:34:11 pm
    Author     : siddharthsinghrathour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="red">
        <form action="Email.jsp">
            To:<input type="text" name="mail" value="Enter The Mail_id"><br>
            Subject:<input type="text" name="sub" value="Enter The Suject"><br>
            
            Message:<input type="text" name="mess">
            
            <input type="submit" value="send">
            <input type="reset" value="reset">
            
            
        </form>
        
    
    </body>
</html>
