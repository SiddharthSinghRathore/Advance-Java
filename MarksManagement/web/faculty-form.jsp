<%-- 
    Document   : faculty-form
    Created on : May 24, 2021, 7:28:12 PM
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
            <title>Faculty Management</title>
            <style>
            div{
                width: 30%;
                padding: 10px;
                border: 2px solid #fa7000;
            }
            
input[type=text], select {
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
        <c:if test="${faculty == null}">        
        <h1 style="color: #f07829;"> Add Faculty Details </h1>
        </c:if>
        <c:if test="${faculty != null}">        
        <h1 style="color: #f07829;"> Edit Faculty Details </h1>
        </c:if>
        <div>
        <c:if test="${faculty != null}">
                            <form action="updateFaculty?id=<c:out value='${faculty.id}' />" method="post">
                        </c:if>
                        <c:if test="${faculty == null}">
                            <form action="insertFaculty" method="post">
                        </c:if>
            <label for="id">ID</label><br/>
            <input type="text" name="id" id="id" placeholder="Ex: RVCEMCAF01" value="<c:out value='${faculty.id}' />" <c:if test="${faculty != null}">disabled</c:if> required/><br/><br/>
            <label for="name">Full Name</label><br/>
            <select name="designation" id="designation">
                <option value="Dr.">Dr.</option>
                <option value="Mr.">Mr.</option>
                <option value="Ms.">Ms.</option>
            </select>
            <input type="text" name="name" id="name" value="<c:out value='${faculty.fullName}' />" style="width: 70%;" required/><br/><br/>
            <label for="email">College Email ID</label><br/>
            <input type="text" name="email" id="email" placeholder="facultyname@rvce.edu.in" pattern="^[a-zA-z.]{3,20}[@][r][v][c][e][.][e][d][u][.][i][n]$" value="<c:out value='${faculty.collegeEmail}' />" required/><br/><br/>
            <input type="submit" value="Save"/>
        </form>
        </div>
            <a href="javascript:history.back()">Go Back</a>
    </center>
        </body>
        <script>
            var id = document.getElementById("id");

            id.addEventListener("keyup", function (event) {
                if (id.validity.patternMismatch) {
                    id.setCustomValidity("ID should match the format RVCEMCAFxx");
                } else {
                    id.setCustomValidity("");
                }
            });
            
            var name = document.getElementById("name");
            
            name.addEventListener("keyup", function (event) {
                if (name.validity.patternMismatch) {
                    name.setCustomValidity("Name should only contain letters from the English Alphabet");
                } else {
                    name.setCustomValidity("");
                }
            });
            
            var email = document.getElementById("email");

            email.addEventListener("keyup", function (event) {
                if (email.validity.patternMismatch) {
                    email.setCustomValidity("Email should match the format facultyname@rvce.edu.in");
                } else {
                    email.setCustomValidity("");
                }
            });
        </script>
        </html>