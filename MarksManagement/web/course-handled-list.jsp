<%-- 
    Document   : course-list
    Created on : May 24, 2021, 10:34:44 PM
    Author     : mnpem
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Courses Handled</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>  
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f07829">
                    <div>
                        <h1 class="navbar-brand">Courses</h1>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/listCoursesHandled?id=<c:out value='${faculty.code}' />" class="nav-link">Courses Handled</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">List of Courses Handled</h3>
                    <hr>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Semester</th>
                                <th>Scheme Year</th>
                                <th>Practical</th>
                                <th>Elective</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="course" items="${listCoursesHandled}">

                                <tr>
                                    <td>
                                        <c:out value="${course.code}" />
                                    </td>
                                    <td>
                                        <c:out value="${course.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${course.semester}" />
                                    </td>
                                    <td>
                                        <c:out value="${course.schemeYear}" />
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${course.isPractice}">
                                                <c:out value="YES" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="NO" />
                                            </c:otherwise>
                                        </c:choose>         
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${course.isElective}">
                                                <c:out value="YES" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="NO" />
                                            </c:otherwise>
                                        </c:choose>      
                                    </td>
                                    <td><a href="listMarks?code=<c:out value='${course.code}' />&isPractice=<c:out value='${course.isPractice}' />">Manage Marks</a></td>
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