<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!doctype html>
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
            font-size: 110%;
        }

        .container-fluid h2 h4 {
            margin: 10px;
        }

        .container-fluid .progress-bar {
            color: rgb(29, 27, 27);
            background-color: ${result.color};
            font-size: 20px;
            border-radius: 10px;
        }

        .youtube-link {
            position: fixed;
            margin-top: 75px;
            margin-left: 30px;
        }
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
    <div class="row justify-content-space-between">
        <div class="col-lg-6 offset-lg-6 justify-content-center" style="margin-top: 75px">
            <h3>
            Great job! You guessed ${result.numberOfRightAnswers} from ${result.numberOfAllWords} words.
            </h3>
        </div>
        <div class="col-lg-6 offset-lg-6" style="margin-top: 10px">
            <div class="progress" style="height: 30px; margin: 5px;
                border-radius: 10px; box-shadow: 4px 4px 14px rgba(0,0,0,0.25)">
                <div class="progress-bar progress-bar-striped progress-bar-animated"
                     role="progressbar" aria-valuenow="${result.width}" aria-valuemin="0" aria-valuemax="100"
                     style="width: ${result.width}%">
                    ${result.percent}%
                </div>
            </div>
            <h2>${allLines.get(0).song.author.name} - ${allLines.get(0).song.name}</h2>
            <div><c:forEach var="line" items="${allLines}">
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
            </c:forEach></div>
        </div>
    </div>
</div>
</body>
</html>