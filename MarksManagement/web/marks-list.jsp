<%-- 
    Document   : marks-list
    Created on : May 27, 2021, 10:52:40 PM
    Author     : mnpem
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Marks Management</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>  
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f07829">
                    <div>
                        <h1 class="navbar-brand">Marks Management</h1>
                    </div>

                </nav>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center">List of Marks</h3>
                    <hr>
                    <!--<div class="container text-left">
                        <a href="/MarksManagement/newMarks?code=<c:out value='${code}' />&isPractice=<c:out value='${isPractice}' />" class="btn btn-success">Add New Marks</a>
                    </div>-->
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>USN</th>
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
                                <c:if test="${isPractice}">
                                <th>Theory SEE</th>
                                <th>Lab SEE</th>
                                </c:if>
                                <th>SEE Total</th>
                                <th>Grand Total</th>
                                <th>Grade</th>
                                <th>Backlog</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="marks" items="${listMarks}">

                                <tr>
                                    <td>
                                        <c:out value="${marks.usn}" />
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.testOne == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.testOne}" />
                                            </c:otherwise>
                                        </c:choose>        
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.testTwo == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.testTwo}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.testThree == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.testThree}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.testAverage == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.testAverage}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.quizOne == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.quizOne}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.quizTwo == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.quizTwo}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.assignment == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.assignment}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <c:if test="${isPractice}">
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.cie == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.cie}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.labManual == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.labManual}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.labTest == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.labTest}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.labCie == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.labCie}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    </c:if>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.cieTotal == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.cieTotal}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <c:if test="${isPractice}">
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.theorySee == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.theorySee}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.labSee == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.labSee}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    </c:if>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.seeTotal == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.seeTotal}" />
                                            </c:otherwise>
                                        </c:choose>  
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${marks.grandTotal == -1}">
                                                <c:out value="-" />
                                            </c:when>
                                            <c:otherwise>
                                                <c:out value="${marks.grandTotal}" />
                                            </c:otherwise>
                                        </c:choose>  
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
                                    <td><a href="/MarksManagement/editMarks?code=<c:out value='${code}' />&isPractice=<c:out value='${isPractice}' />&usn=<c:out value='${marks.usn}'/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="/MarksManagement/deleteMarks?code=<c:out value='${code}' />&isPractice=<c:out value='${isPractice}' />&usn=<c:out value='${marks.usn}' />">Delete</a></td>
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