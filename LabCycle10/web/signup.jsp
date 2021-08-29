
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <form method="get" action="SignUp">
            <table>
                <caption>Registration Details</caption>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="uname" required minlength="6" maxlength="12"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pass" required minlength="5" maxlength="8"></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="cpass" required minlength="5" maxlength="8"></td>
                </tr>
                <tr>
                    <td><input type="reset"></td>
                    <td><input type="submit"></td>
                </tr>
            </table>
            
        </form>
    </center>
    </body>
</html>
