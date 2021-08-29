<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            Cookie cks =new Cookie("jsp_cookie",request.getParameter("This is Jsp Cookie"));
            cks.setMaxAge(10);
            response.addCookie(cks);
            out.println("Cookie Submiteed Sucessfully");
        %>
        <a href="check.jsp">
            Check Cookie
        </a>           
    </body>
</html>
<a href="index.jsp"></a>