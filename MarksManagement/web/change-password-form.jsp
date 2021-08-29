<%-- 
    Document   : course-form
    Created on : May 24, 2021, 10:40:04 PM
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
            <title>Change Password</title>
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
        <h1 style="color: #f07829;"> Change Password </h1>
        <div>
            <form action="changePassword?id=<c:out value='${id}' />" method="post">
            <label for="id">Enter Old Password</label><br/>
            <input type="text" name="id" id="id" value="<c:out value='${id}' />" disabled="true" required/><br/><br/>  
            <label for="oldPassword">Enter Old Password</label><br/>
            <input type="password" name="oldPassword" id="oldPassword" required/><br/><br/>
            <label for="newPassword">Enter New Password</label><br/>
            <input type="password" name="newPassword" id="newPassword" required/><br/><br/>
            <label for="repeatNewPassword">Repeat New Password</label><br/>
            <input type="password" name="repeatNewPassword" id="repeatNewPassword" required/><br/><br/>
            <input type="submit" value="Save"/>
        </form>
        </div>
            <a href="javascript:history.back()">Go Back</a>
    </center>
                      
        </body>
        <script>
         
        </script>
        </html>
