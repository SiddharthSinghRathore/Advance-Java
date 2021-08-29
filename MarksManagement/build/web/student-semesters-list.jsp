<%-- 
    Document   : faculty-list
    Created on : May 24, 2021, 6:11:08 PM
    Author     : mnpem
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Student Semesters</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>  
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f07829">
                    <div>
                        <h1 class="navbar-brand">Student Semesters</h1>
                    </div>

                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">List of Semesters</h3>
                    <hr>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Semester</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="semester" items="${semesters}">

                                <tr>
                                    <td>
                                        <c:out value="${semester}" />
                                    </td>
                                    <td><a href="/MarksManagement/listStudentCourses?usn=<c:out value='${usn}'/>&semester=<c:out value='${semester}'/>">Courses</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
                       <div class="container text-left">

                        <a href="javascript:history.back()" class="btn btn-success">Go Back</a>
                    </div>
        </body>

        </html>