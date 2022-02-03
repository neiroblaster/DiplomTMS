<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Song info</title>
</head>
<body>

<form:form action="saveSong" modelAttribute="song">

    <form:hidden path="id"/>
    Author <form:input path="author.name"/>
    <br><br>
    Name of the song <form:input path="name"/>
    <br><br>
    Link <form:input path="link" placeholder="Link from Youtube"/>
    <br><br>
    <form:textarea path="lyrics" cols="50" rows="30"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>
