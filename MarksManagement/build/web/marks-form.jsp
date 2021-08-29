<%-- 
    Document   : marks-form
    Created on : May 27, 2021, 11:15:57 PM
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
            <title>Marks Management</title>
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
        <c:if test="${marks == null}">        
        <h1 style="color: #f07829;"> Add Marks Details </h1>
        </c:if>
        <c:if test="${marks != null}">        
        <h1 style="color: #f07829;"> Edit Marks Details </h1>
        </c:if>
        <div>
        <c:if test="${marks != null}">
                            <form action="updateMarks?code=<c:out value='${code}'/>&isPractice=<c:out value='${isPractice}' />&usn=<c:out value='${usn}' />" method="post">
                        </c:if>
                        <c:if test="${marks == null}">
                            <form action="insertMarks?code=<c:out value='${code}'/>&isPractice=<c:out value='${isPractice}' />" method="post">
                        </c:if>
            <label for="usn">USN</label><br/>
            <input type="text" name="usn" id="usn" placeholder="Ex: 1RZ19MCA15" value="<c:out value='${marks.usn}' />" pattern="^[1][R][DVZ][0-9]{2}[M][C][A][0-9]{2}$" <c:if test="${marks != null}">disabled</c:if>/><br/><br/>
            <label for="testOne">Test 1</label><br/>
            <input type="text" name="testOne" id="marks" placeholder="Out of 50" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.testOne != -1}"><c:out value='${marks.testOne}' /></c:if>"/><br/><br/>
            <label for="testTwo">Test 2</label><br/>
            <input type="text" name="testTwo" id="marks" placeholder="Out of 50" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.testTwo != -1}"><c:out value='${marks.testTwo}' /></c:if>"/><br/><br/>
            <label for="testThree">Test 3</label><br/>
            <input type="text" name="testThree" id="marks" placeholder="Out of 50" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.testThree != -1}"><c:out value='${marks.testThree}' /></c:if>"/><br/><br/>
            <label for="testAverage">Quiz 1</label><br/>
            <input type="text" name="quizOne" id="marks" placeholder="Out of 10" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.quizOne != -1}"><c:out value='${marks.quizOne}' /></c:if>"/><br/><br/>
            <label for="quizTwo">Quiz 2</label><br/>
            <input type="text" name="quizTwo" id="marks" placeholder="Out of 10" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.quizTwo != -1}"><c:out value='${marks.quizTwo}' /></c:if>"/><br/><br/>
            <label for="assignment">Assignment</label><br/>
            <input type="text" name="assignment" id="marks" placeholder="Out of 30" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.assignment != -1}"><c:out value='${marks.assignment}' /></c:if>"/><br/><br/>
            <label for="labManual">Lab Manual</label><br/>
            <input type="text" name="labManual" id="marks" placeholder="Out of 100" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.labManual != -1}"><c:out value='${marks.labManual}' /></c:if>" <c:if test="${!isPractice}">disabled</c:if>/><br/><br/>
            <label for="labTest">Lab Test</label><br/>
            <input type="text" name="labTest" id="marks" placeholder="Out of 50" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.labTest != -1}"><c:out value='${marks.labTest}' /></c:if>" <c:if test="${!isPractice}">disabled</c:if>/><br/><br/>
            <label for="labSee">SEE</label><br/>
            <input type="text" name="seeTotal" id="marks" placeholder="Out of 100" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.seeTotal != -1}"><c:out value='${marks.seeTotal}' /></c:if>" <c:if test="${isPractice}">disabled</c:if>/><br/><br/>
            <label for="theorySee">Theory SEE</label><br/>
            <input type="text" name="theorySee" id="marks" placeholder="Out of 100" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.theorySee != -1}"><c:out value='${marks.theorySee}' /></c:if>" <c:if test="${!isPractice}">disabled</c:if>/><br/><br/>
            <label for="labSee">LAB SEE</label><br/>
            <input type="text" name="labSee" id="marks" placeholder="Out of 50" pattern="[0-9]+[.]?[0-9]+" value="<c:if test="${marks.labSee != -1}"><c:out value='${marks.labSee}' /></c:if>" <c:if test="${!isPractice}">disabled</c:if>/><br/><br/>
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
            
            var marks = document.getElementById("marks");

            marks.addEventListener("keyup", function (event) {
                if (marks.validity.patternMismatch) {
                    marks.setCustomValidity("Marks entered should be within given range(0 - Out of Maximum Marks)");
                } else {
                    marks.setCustomValidity("");
                }
            });
            
            </script>
        </html>
