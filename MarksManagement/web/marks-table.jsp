<%-- 
    Document   : marks-table
    Created on : May 28, 2021, 3:11:27 AM
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
                    <h3 class="text-center">Marks</h3>
                    <hr>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Test 1</th>
                                <th>Test 2</th>
                                <th>Test 3</th>
                                <th>Test Average</th>
                                <th>Quiz 1</th>
                                <th>Quiz 2</th>
                                <th>Assignment</th>
                                <c:if test="${isPractice}">
                                <th>CIE</th>
                                <th>Lab Manual</th>
                                <th>Lab Test</th>
                                <th>Lab CIE</th>
                                </c:if>
                                <th>CIE Total</th>
                                <th>Grade</th>
                                <th>Backlog</th>
                            </tr>
                        </thead>
                        <tbody>
                                <tr>
                                    <td>
                                        <c:if test ="${marks.testOne != -1}"><c:out value="${marks.testOne}" /></c:if>
                                    </td>
                                    <td>
                                        <c:if test ="${marks.testTwo != -1}"><c:out value="${marks.testTwo}" /></c:if>
                                    </td>
                                    <td>
                                        <c:if test ="${marks.testThree != -1}"><c:out value="${marks.testThree}" /></c:if>
                                    </td>
                                    <td>
                                        <c:if test ="${marks.testAverage != -1}"><c:out value="${marks.testAverage}" /></c:if>
                                    </td>
                                    <td>
                                        <c:if test ="${marks.quizOne != -1}"><c:out value="${marks.quizOne}" /></c:if>
                                    </td>
                                    <td>
                                        <c:if test ="${marks.quizTwo != -1}"><c:out value="${marks.quizTwo}" /></c:if>
                                    </td>
                                    <td>
                                        <c:if test ="${marks.assignment != -1}"><c:out value="${marks.assignment}" /></c:if>
                                    </td>
                                    <c:if test="${isPractice}">
                                    <td>
                                        <c:if test ="${marks.cie != -1}"><c:out value="${marks.cie}" /></c:if>
                                    </td>
                                    <td>
                                        <c:if test ="${marks.labManual != -1}"><c:out value="${marks.labManual}" /></c:if>
                                    </td>
                                    <td>
                                        <c:if test ="${marks.labTest != -1}"><c:out value="${marks.labTest}" /></c:if>
                                    </td>
                                    <td>
                                        <c:if test ="${marks.labCie != -1}"><c:out value="${marks.labCie}" /></c:if>
                                    </td>
                                    </c:if>
                                    <td>
                                       <c:if test ="${marks.cieTotal != -1}"><c:out value="${marks.cieTotal}" /></c:if>
                                    </td>
                                    <td>
                                       <c:out value="${marks.grade}" />
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.isBacklog}">
                                                <c:out value="YES" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="NO" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                </tr>
                        </tbody>

                    </table>
                </div>
            </div>
                                               <div class="container text-left">

                        <a href="javascript:history.back()" class="btn btn-success">Go Back</a>
                    </div>
        </body>

        </html>