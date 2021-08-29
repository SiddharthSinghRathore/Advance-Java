<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>First JSP PAGE</h1>
        <%!
            int a=20;
            int b=20;
            
            public int sum()
            {
                   return a+b;
            }
            
        %>
        <%
            out.println(a);
            out.println(b);
            out.println("<br>");
            out.println("ADDITION:"+sum());

        %>
        
        <h1 style="color:red"> Sum is <%= sum() %>   </h1>
        
        
    </body>
</html>
