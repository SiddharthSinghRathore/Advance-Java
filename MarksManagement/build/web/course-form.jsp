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
            <title>Course Management</title>
            <style>
                body{
                    color: #d96507;
                    font-weight: bold;
                }
            div{
                width: 30%;
                padding: 10px;
                border: 2px solid #fa7000;
            }
            
input[type=text], input[type=number], select {
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
        <c:if test="${course == null}">        
        <h1 style="color: #f07829;"> Add Course Details </h1>
        </c:if>
        <c:if test="${course != null}">        
        <h1 style="color: #f07829;"> Edit Course Details </h1>
        </c:if>
        <div>
        <c:if test="${course != null}">
                            <form action="updateCourse?code=<c:out value='${course.code}' />" method="post">
                        </c:if>
                        <c:if test="${course == null}">
                            <form action="insertCourse" method="post">
                        </c:if>
            <label for="code">Code</label><br/>
            <input type="text" name="code" id="code" placeholder="Ex: 18MCA453" value="<c:out value='${course.code}' />" pattern="^[0-9]{2}[MH][ACS][AST][0-9]{2,3}$" <c:if test="${course != null}">disabled</c:if> required/><br/><br/>
            <label for="name">Name</label>
            <label for="semester" style="padding-left: 248px;">Semester</label>
            <label for="schemeYear" style="padding-left: 55px;">Scheme Year</label>
            <br/>
            <input type="text" name="name" id="name" placeholder="Name" style="width: 50%;" value="<c:out value='${course.name}' />" required/>
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
            Is it a Practical Oriented Course?<input type="checkbox" name="isPractice" id="isPractice" value="isPractice"/>
            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Is it an Elective? <input type="checkbox" name="isElective" id="isElective" value="isElective"/>
            <br/><br/>
            <label for="faculty">Handled By</label>
            <label for="credits" style="padding-left: 267px;">Credits</label><br/>
            <input type="text" id="facultyOne" name="facultyOneId" placeholder="RVCEMCAF01" pattern="^[R][V][C][E][M][C][A][F][0-9]{2}$" style="width: 30%;" value="<c:out value='${course.facultyOneId}' />" required>
            <input type="text" id="facultyTwo" name="facultyTwoId" placeholder="RVCEMCAF02" pattern="^[R][V][C][E][M][C][A][F][0-9]{2}$" style="width: 30%;" value="<c:out value='${course.facultyTwoId}' />" required>
            <input type="number" id="credits" name="credits" style="width: 30%;" value="<c:out value='${course.credits}' />" required><br/><br/>
            <input type="submit" value="Save"/>             
        </form>
        </div>
            <a href="javascript:history.back()">Go Back</a>
    </center>
                      
        </body>
        <script>
            var code = document.getElementById("code");

            code.addEventListener("keyup", function (event) {
                if (code.validity.patternMismatch) {
                    code.setCustomValidity("Code should match the format yyMCAxx");
                } else {
                    code.setCustomValidity("");
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
            
            var facultyOne = document.getElementById("facultyOne");

            facultyOne.addEventListener("keyup", function (event) {
                if (facultyOne.validity.patternMismatch) {
                    facultyOne.setCustomValidity("ID should match the format RVCEMCAFxx");
                } else {
                    facultyOne.setCustomValidity("");
                }
            });
            
            var facultyTwo = document.getElementById("facultyTwo");

            facultyTwo.addEventListener("keyup", function (event) {
                if (facultyTwo.validity.patternMismatch) {
                    facultyTwo.setCustomValidity("ID should match the format RVCEMCAFxx");
                } else {
                    facultyTwo.setCustomValidity("");
                }
            });
            
        </script>
        </html>
