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
            <title>Result</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>  
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f07829">
                    <div>
                        <h1 class="navbar-brand">Result</h1>
                    </div>
                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">Result for Semester <c:out value="${semester}" /></h3>
                    <hr>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Course Code</th>
                                <th>Credits</th>
                                <th>Grade</th>
                                <th>Grade Points</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="result" items="${results}">

                                <tr>
                                    <td>
                                        <c:out value="${result.courseCode}" />
                                    </td>
                                    <td>
                                        <c:out value="${result.courseCredits}" />
                                    </td>
                                    <td>
                                        <c:out value="${result.grade}" />
                                    </td>
                                    <td>
                                        <c:out value="${result.gradePoint}" />
                                    </td>
                                </tr>
                            </c:forEach>
                                <tr>
                                    <td>
                                        -
                                    </td>
                                    <td>
                                        -
                                    </td>
                                    <td>
                                        SGPA
                                    </td>
                                    <td>
                                        <c:out value="${sgpa}" />
                                    </td>
                                </tr>
                        </tbody>

                    </table>
                </div>
            </div>
                                    <a href="javascript:history.back()">Go Back</a>
        </body>

        </html>