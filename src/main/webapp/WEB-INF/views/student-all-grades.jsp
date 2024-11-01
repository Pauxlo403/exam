<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/style.css" rel="stylesheet"/>
</head>
<body class="body">
<div class="flex-row">
    <h1>All grades</h1>
    <input type="button" value="Log out" class="button button_logout" onclick="window.location.href='logout'">
</div>

<form:form action="studentFilter" cssClass="">
    <select name="idSubject" class="select">
        <option value="0"
                <c:if test="${0 == selectedSubjectId}">
                    <c:out value="selected=selected"/>
                </c:if>>ALL</option>
        <c:forEach items="${subjects}" var="subj">
            <option value="${subj.id}"
                    <c:if test="${subj.id == selectedSubjectId}">
                        <c:out value="selected=selected"/>
                    </c:if>>${subj}</option>
        </c:forEach>
    </select>
    <input type="date" name="dateGrade"/>
    <input type="submit" value="Filter" class="button button_filter">
</form:form>

<table class="table">
    <tr>
        <th>Subject</th>
        <th>Student</th>
        <th>Grade</th>
        <th>Date</th>
        <th>Comment</th>
    </tr>
    <c:forEach var="grade" items="${gradesAllForStudent}">
        <tr>
            <td>${grade.subject.title}</td>
            <td>${grade.student.firstName} ${grade.student.lastName}</td>
            <td>${grade.grade}</td>
            <td>${grade.datecurrent}</td>
            <td>${grade.comment}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
