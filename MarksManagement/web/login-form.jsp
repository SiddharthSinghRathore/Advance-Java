<%-- 
    Document   : login-form
    Created on : May 25, 2021, 2:57:33 AM
    Author     : mnpem
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login</title>
            <style>
            div{
                width: 30%;
                padding: 10px;
                border: 2px solid #fa7000;
            }
            
input[type=text], input[type=password] {
  width: 90%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #d96507;
  border-radius: 4px;
  box-sizing: border-box;
}

select{
    width: 20%;
}

input[type=submit] {
  width: 90%;
  background-color: #fa7000;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #d96507;
}

label {
color: #d96507;
font-weight: bold;
display: block;
float: left;
padding-left: 20px;
}

</style>
        </head>

        <body bgcolor="#f7f6f2">                       
        <center>    
        <h1 style="color: #f07829;"> Login </h1>
        <div>
                            <form action="authenticate" method="post">
            <label for="id">ID</label><br/>
            <input type="text" name="id" id="id" placeholder="Ex: 1RZ19MCA15" required/><br/><br/>
            <label for="id">Password</label><br/>
            <input type="password" name="password" id="password" required/><br/><br/>
            <input type="submit" value="Login"/>
        </form>
        </div>
    </center>
        </body>

        </html>
