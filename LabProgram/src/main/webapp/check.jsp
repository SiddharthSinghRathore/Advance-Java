
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            Cookie []cks = request.getCookies();
            int temp=0;
            
            for(int i=0;i<cks.length;i++)
            {
                if(cks[i].getName().equals("jsp_cookie"))
                {
                    out.println("<font color='green' size='30px'>"+ cks[i].getName()+" :"+ cks[i].getValue() +"</font>");
                    temp=1;
                }
                    
            }
            if(temp==0)
            {
               out.println("<font color='red' size='30px'>JSP Cookie Not Found</font>");

            }
        
        %>

    </body>
</html>
