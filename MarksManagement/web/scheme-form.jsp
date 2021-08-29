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
            <title>Scheme Management</title>
            <style>
            div{
                width: 30%;
                padding: 10px;
                border: 2px solid #fa7000;
            }
            
input[type=text], input[type=number] {
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
        <c:if test="${scheme == null}">        
        <h1 style="color: #f07829;"> Add Scheme Details </h1>
        </c:if>
        <c:if test="${scheme != null}">        
        <h1 style="color: #f07829;"> Edit Scheme Details </h1>
        </c:if>
        <div>
        <c:if test="${scheme != null}">
                            <form action="updateScheme?schemeYear=<c:out value='${scheme.schemeYear}' />" method="post">
                        </c:if>
                        <c:if test="${scheme == null}">
                            <form action="insertScheme" method="post">
                        </c:if>
            <label for="schemeYear">Scheme Year</label><br/>
            <input type="text" name="schemeYear" id="schemeYear" placeholder="2018" pattern="^[2][0][0-9]{2}$" value="<c:out value='${scheme.schemeYear}' />" <c:if test="${scheme != null}">disabled</c:if> required/><br/><br/>
            <input type="submit" value="Save"/>
        </form>
        </div>
            <a href="javascript:history.back()">Go Back</a>
    </center>
        </body>
        <script>
            var schemeYear = document.getElementById("schemeYear");

            schemeYear.addEventListener("keyup", function (event) {
                if (schemeYear.validity.patternMismatch) {
                    schemeYear.setCustomValidity("Scheme year should match the format yyyy");
                } else {
                    schemeYear.setCustomValidity("");
                }
            });
        </script>
        </html>