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
            <title>Course Management</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>  
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f07829">
                    <div>
                        <h1 class="navbar-brand"> Course Management</h1>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/listCourses" class="nav-link">Courses</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">List of Courses</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/newCourse" class="btn btn-success">Add New Course</a>
                    </div>
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
                                <th>Faculty One ID</th>
                                <th>Faculty Two ID</th>
                                <th>Credits</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="course" items="${listCourse}">

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
                                    <td>
                                        <c:out value="${course.facultyOneId}" />
                                    </td>
                                    <td>
                                        <c:out value="${course.facultyTwoId}" />
                                    </td>
                                    <td>
                                        <c:out value="${course.credits}" />
                                    </td>
                                    <td><a href="editCourse?code=<c:out value='${course.code}' />">Edit</a> &nbsp;&nbsp; <a href="deleteCourse?code=<c:out value='${course.code}' />">Delete</a></td>
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