<%-- 
    Document   : student-list
    Created on : May 27, 2021, 11:12:58 AM
    Author     : mnpem
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Student Management</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>  
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f07829">
                    <div>
                        <h1 class="navbar-brand">Student Management</h1>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="/MarksManagement/listStudents" class="nav-link">Students</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">List of Students</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="/MarksManagement/newStudent" class="btn btn-success">Add New Student</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>USN</th>
                                <th>Full Name</th>
                                <th>Semester</th>
                                <th>Scheme Year</th>
                                <th>College Email</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="student" items="${listStudent}">

                                <tr>
                                    <td>
                                        <c:out value="${student.usn}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.fullName}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.semester}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.schemeYear}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.collegeEmail}" />
                                    </td>
                                    <td><a href="/MarksManagement/editStudent?usn=<c:out value='${student.usn}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="/MarksManagement/deleteStudent?usn=<c:out value='${student.usn}' />">Delete</a></td>
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