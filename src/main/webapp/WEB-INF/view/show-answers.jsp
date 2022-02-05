<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<body>
<h2>${allLines.get(0).song.author.name} - ${allLines.get(0).song.name}</h2>

<div>
    ${allLines.get(0).song.link}
</div>

<h2>Lyrics</h2>

<br>
<c:forEach var="line" items="${allLines}">
    <%--                <br>--%>
    <div style="font-size: 22px"><c:forEach var="word" items="${allWords}">
        <c:set var="continueExecuting" scope="request" value="true"/>
        <c:if test="${word.sline.id == line.id}">
            <c:forEach var="everyAnswer" items="${answers.answerList}">
                <c:choose>
                    <c:when test="${everyAnswer.wordId == word.id && everyAnswer.check eq true}">
                        <b><span hidden>${word.word}/</span></b>
                        <b><span style='color: limegreen'>${everyAnswer.clientAnswer}</span></b>
                        <c:set var="continueExecuting" scope="request" value="false"/>
                    </c:when>
                    <c:when test="${everyAnswer.wordId == word.id && everyAnswer.check eq false}">
                        <span style="color: darkgray">${word.word}/</span>
                        <b><span style='color: orangered'>${everyAnswer.clientAnswer}</span></b>

                        <c:set var="continueExecuting" scope="request" value="false"/>
                    </c:when>
                </c:choose>
            </c:forEach>
            <c:if test="${continueExecuting eq true}">
                <span>${word.word}</span>
            </c:if>
        </c:if>
    </c:forEach></div>
</c:forEach>

</body>
</html>