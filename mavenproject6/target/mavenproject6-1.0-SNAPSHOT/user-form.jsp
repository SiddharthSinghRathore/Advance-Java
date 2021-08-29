<%-- 
    Document   : faculty-form
    Created on : May 24, 2021, 7:28:12 PM
    Author     : mnpem
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Students Result System</title>
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
input[type=email], select {
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
        <c:if test="${user == null}">        
        <h1 style="color: #f07829;"> Add Students Details </h1>
        </c:if>
        <c:if test="${user != null}">        
        <h1 style="color: #f07829;"> Edit Students Details </h1>
        </c:if>
        <div>
        <c:if test="${user != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insert" method="post">
                        </c:if>
            <label for="usn">USN</label><br/>
            <input type="text" required name="usn" id="usn" placeholder="Ex: 1RZ19MCA15"/><br/><br/>
            <label for="name">Full Name</label>
            <label for="semester" style="padding-left: 330px;">Semester</label>
            <br/>
            <input type="text" required name="name" id="name" placeholder="Full Name" style="width: 70%;"/>
            <!-- TODO: Add electives selection when semester 3/ 4 are chosen -->
            <select name="semester" id="semester" required>
                <option value="-">-</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            <br/><br/>
            <label for="email">College Email ID</label><br/>
            <input type="email" required name="email" id="email" placeholder="name.batch@rvce.edu.in"/><br/><br/>
            <input type="submit" value="Save"/>
        </form>
        </div>
    </center>
                                
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>