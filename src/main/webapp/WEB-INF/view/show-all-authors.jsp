<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>

<c:import url="header.jsp"/>
<br><br><br>
<c:forEach var="author" items="${authors}">
    ${author.name}
    <br>
</c:forEach>

</body>
</html>
