<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <style>
        .progress-bar {
            color: rgb(29, 27, 27);
            background-color: rgb(49, 241, 32);
            font-size: 20px;
            border-radius: 10px;
        }

    </style>
</head>
<body>
<h2>${allLines.get(0).song.author.name} - ${allLines.get(0).song.name}</h2>

<div>
    ${allLines.get(0).song.link}
</div>

<h2>Lyrics</h2>
<br><br>
<c:set var="numberOfRightAnswers" scope="request" value="${numberOfRightAnswers}"/>
<div class="progress"  style="height: 30px; width: 800px; margin: 5px; border-radius: 10px;">
    <div class="progress-bar progress-bar-striped progress-bar-animated"
         role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: 50%">25%</div>
</div>

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