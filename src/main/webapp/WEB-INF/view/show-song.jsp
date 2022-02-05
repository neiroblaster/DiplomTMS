<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<body>

<h2>${allLines.get(0).song.author.name} - ${allLines.get(0).song.name}</h2>

<div>
    ${allLines.get(0).song.link}
</div>

<h2>Lyrics</h2>
<br><form:form action="checkAnswers" modelAttribute="answersFromClient">
    <c:forEach var="line" items="${allLines}">
        <c:url var="checkButton" value="/checkAnswers">
            <c:param name="songId" value="${line.song.id}"/>
        </c:url>
        <c:url var="showButton" value="/showSong">
            <c:param name="songId" value="${line.song.id}"/>
        </c:url>
        <br>
        <c:forEach var="word" items="${allWords}">
            <c:if test="${word.sline.id == line.id}">
                <span>${word.word}</span>
                <c:if test="${word.showed eq false}">
                    <form:input path="answersFromClient"/>
                </c:if>
            </c:if>
        </c:forEach>
    </c:forEach>

    <br><br>
    <input type="submit" value="CHECK ANSWERS"/>
</form:form>

<br>
<input type="button" value="CHANGE WORDS"
       onclick="window.location.href = '${showButton}'"/>

<c:forEach var="answersFromDAO" items="${answersFromDAO.answersFromDAO}">
    <div hidden>${answersFromDAO}</div>
</c:forEach>

</body>
</html>