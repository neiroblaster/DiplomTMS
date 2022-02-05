<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Hello!</title>
</head>
<body>
    <div>
        <c:forEach var="line" items="${allLines}">
            ${line.stext}
        </c:forEach>
        <br><br>
        <c:forEach var="word" items="${allWords}">
            ${word.word}
        </c:forEach>
    </div>
</body>
</html>
