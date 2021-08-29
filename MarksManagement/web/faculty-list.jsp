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
            <title>Faculty Management</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>  
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f07829">
                    <div>
                        <h1 class="navbar-brand">Faculty Management</h1>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="/MarksManagement/listFaculties" class="nav-link">Faculties</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">List of Faculties</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="/MarksManagement/newFaculty" class="btn btn-success">Add New Faculty</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Full Name</th>
                                <th>College Email</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="faculty" items="${listFaculty}">

                                <tr>
                                    <td>
                                        <c:out value="${faculty.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${faculty.designation} ${faculty.fullName}" />
                                    </td>
                                    <td>
                                        <c:out value="${faculty.collegeEmail}" />
                                    </td>
                                    <td><a href="/MarksManagement/editFaculty?id=<c:out value='${faculty.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="/MarksManagement/deleteFaculty?id=<c:out value='${faculty.id}' />">Delete</a></td>
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