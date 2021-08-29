<%-- 
    Document   : student-form
    Created on : May 27, 2021, 11:15:54 AM
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
        <c:if test="${student == null}">        
        <h1 style="color: #f07829;"> Add Student Details </h1>
        </c:if>
        <c:if test="${student != null}">        
        <h1 style="color: #f07829;"> Edit Student Details </h1>
        </c:if>
        <div>
        <c:if test="${student != null}">
                            <form action="updateStudent?usn=<c:out value='${student.usn}' />" method="post">
                        </c:if>
                        <c:if test="${student == null}">
                            <form action="insertStudent" method="post">
                        </c:if>
                                            <label for="usn">USN</label><br/>
                                            <input type="text" name="usn" id="usn" placeholder="Ex: 1RZ19MCA15" value="<c:out value='${student.usn}' />" pattern="^[1][R][DVZ][0-9]{2}[M][C][A][0-9]{2}$" <c:if test="${student != null}">disabled</c:if>  required/><br/><br/>
            <label for="name">Full Name</label>
            <label for="semester" style="padding-left: 220px;">Semester</label>
            <label for="schemeYear" style="padding-left: 55px;">Scheme Year</label>
            <br/>
            <input type="text" name="fullName" id="name" placeholder="Full Name" style="width: 50%;" value="<c:out value='${student.fullName}' />" required/>
            <select name="semester" id="semester" required>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
            </select>
            <select name="schemeYear" id="schemeYear" required>
                <c:forEach var="schemeYear" items="${schemeYears}">
                <option value="<c:out value='${schemeYear.schemeYear}' />"><c:out value='${schemeYear.schemeYear}' /></option>
                </c:forEach>
            </select>
            <br/><br/>
            <label for="email">College Email ID</label><br/>
            <input type="text" name="collegeEmail" id="email" placeholder="name.batch@rvce.edu.in" pattern="^[a-zA-z]{3,20}[.][m][c][a][0-9]{2}[@][r][v][c][e][.][e][d][u][.][i][n]$" value="<c:out value='${student.collegeEmail}' />" required/><br/><br/>
            <input type="submit" value="Save"/>
        </form>
        </div>
            <a href="javascript:history.back()">Go Back</a>
    </center>
        </body>
        <script>
            var usn = document.getElementById("usn");

            id.addEventListener("keyup", function (event) {
                if (id.validity.patternMismatch) {
                    id.setCustomValidity("USN should match the format 1RxyyMCAxx");
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
                    email.setCustomValidity("Email should match the format studentname.batch@rvce.edu.in");
                } else {
                    email.setCustomValidity("");
                }
            });
        </script>
        </html>