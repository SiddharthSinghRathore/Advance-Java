<%-- 
    Document   : registered-courses-list
    Created on : May 28, 2021, 2:58:43 AM
    Author     : mnpem
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <title>View Marks</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>  
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f07829">
                    <div>
                        <h1 class="navbar-brand">View Marks</h1>
                    </div>
                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">List of Registered Courses</h3>
                    <hr>
                    <div class="container text-left">
                        <a href="/MarksManagement/registerForACourseForm?usn=<c:out value='${usn}' />&semester=<c:out value='${semester}' />" class="btn btn-success">Register for an Elective</a>
                    </div>
                    <div class="container text-left">
                        <a href="/MarksManagement/studentResult?usn=<c:out value='${usn}' />&semester=<c:out value='${semester}' />" class="btn btn-success">Result</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="course" items="${courses}">

                                <tr>
                                    <td>
                                        <c:out value="${course.code}" />
                                    </td>
                                    <td>
                                        <c:out value="${course.name}" />
                                    </td>
                                    <td><a href="/MarksManagement/showStudentMarks?code=<c:out value='${course.code}' />&isPractice=<c:out value='${course.isPractice}' />&usn=<c:out value='${usn}' />">Check Marks</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
                    <a href="javascript:history.back()">Go Back</a>
        </body>

        </html>