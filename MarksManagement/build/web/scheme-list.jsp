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
            <title>Scheme Management</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>  
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #f07829">
                    <div>
                        <h1 class="navbar-brand">Scheme Management</h1>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="/MarksManagement/listSchemes" class="nav-link">Schemes</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                    <div class="container text-left">

                        <a href="/MarksManagement/newScheme" class="btn btn-success">Add New Scheme</a>
                    </div>
                <div class="container">
                    <h3 class="text-center">List of Schemes</h3>
                    <hr>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Scheme Year</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="scheme" items="${listSchemes}">

                                <tr>
                                    <td>
                                        <c:out value="${scheme.schemeYear}" />
                                    </td>
                                    <td></a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="/MarksManagement/deleteScheme?schemeYear=<c:out value='${scheme.schemeYear}' />">Delete</a></td>
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