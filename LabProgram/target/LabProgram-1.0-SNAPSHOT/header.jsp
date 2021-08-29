<%@ page import="java.util.Date" %>
<html>
<head>
<title> </title>
</head>
<body>
<h1>
My website. Time:
<% Date d=new Date();%>
<%=d%>
</h1>
</body>
</html>

<html>
<head>
<title>Index Page</title>
</head>
<body>
<center>
<jsp:include page="header.jsp"/>
<br />
<h1>
Enter Data
</h1>
<br />
<form method="post" action="val.jsp">
Username:
<input type="text" name="uname"/>
<br/> password:
<input type="password" name="upass"/>
<br/>
<input type="submit" value="login">
</form>
</center>
</body>
</html>
