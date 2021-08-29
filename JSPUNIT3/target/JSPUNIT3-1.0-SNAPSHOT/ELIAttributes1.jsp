<%-- 
    Document   : ELIAttributes1
    Created on : 12-May-2021, 12:02:12 pm
    Author     : siddharthsinghrathour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page isELIgnored="true"%>
<html>
<head>
<title>Tag Example</title>
</head>
<body>
<font color="blue" size="5"> 
<c:set var="name1" value="Rose"></c:set>
<c:set var="name2" value="India"></c:set> <c:choose>
<c:when test="${name1 eq 'Rose'}">
<c:set var="name" value="${name1}${name2}" />
<c:out value="${name}"></c:out>
</c:when>

<c:otherwise>
<b>${name}</b>
</c:otherwise>
</c:choose> 
</font>
</body>
</html>