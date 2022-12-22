<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <style>

        body {
            background-color: #f1f1f1;
            color: #0f141e;
        }

        .container-fluid {
            font-size: 120%;
        }

        .youtube-link {
            position: fixed;
            margin-top: 75px;
            margin-left: 30px;
        }

        .btn-check-position {
            position: fixed;
            right: 30px;
            top: 80px;
        }

        /*@media (max-width: 500px) {*/
        /*    .row .col-lg-6 {*/
        /*        top: 300px;*/
        /*    }*/
        /*}*/

    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row justify-content-start">
        <c:import url="header.jsp"/>
    </div>
    <div class="youtube-link">
        ${allLines.get(0).song.link}
    </div>
</div>
<div class="row justify-content-space-between">
    <div class="col-lg-6 offset-lg-6" style="margin-top: 75px">
        <h2>${allLines.get(0).song.author.name} - ${allLines.get(0).song.name}</h2>
        <br>
        <form:form action="checkAnswers" modelAttribute="answersFromClient">
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
            <div class="btn-check-position">
                <input type="submit" value="CHECK ANSWERS"/>
            </div>
        </form:form>

        <br>
        <input type="button" value="CHANGE WORDS" onclick="window.location.href = '${showButton}'"/>
    </div>
</div>

<%--<div><c:forEach var="answersFromDAO" items="${answersFromDAO.answersFromDAO}">--%>
<%--    <div hidden>--%>
<%--            ${answersFromDAO}--%>
<%--    </div>--%>
<%--</c:forEach></div>--%>

</body>

</html>