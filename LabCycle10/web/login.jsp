
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form method="get" action="LoginCheck">
            <table>
                <caption>Login Details</caption>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="uname" required></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pass" required></td>
                </tr>
                <tr>
                    <td><input type="reset"></td>
                    <td><input type="submit"></td>
                </tr>
            </table>
            <a href="signup.jsp">Sign up</a>
        </form>
    </center>
    </body>
</html>
