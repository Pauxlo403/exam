<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Home</title>
    <link href="/resources/css/style.css" rel="stylesheet"/>
</head>
<body class="body">
<div class="flex-row">
    <h1>Home</h1>
    <input type="button" value="Log out" class="button button_logout" onclick="window.location.href='logout'">
</div>

<security:authorize access="hasRole('TEACHER')">
    <form:form action="teacherFilter">
        <select name="usernameStudent" class="select" >
            <option value="all"
                    <c:if test="${all == usernameStudent}">
                        <c:out value="selected=selected"/>
                    </c:if>>ALL</option>
            <c:forEach items="${students}" var="stud">
                <option value="${stud.username}"
                        <c:if test="${stud.username == usernameStudent}">
                            <c:out value="selected=selected"/>
                        </c:if>>${stud}</option>
            </c:forEach>
        </select>
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
        <input type="date" name="dateGrade" />
        <input type="submit" value="Filter" class="button button_filter">
    </form:form>

    <input type="button" value="Create new grade" class="button button_create" onclick="window.location.href='teacherCreateGrade'"/>
    <table class="table">
        <tr>
            <th>Subject</th>
            <th>Student</th>
            <th>Grade</th>
            <th>Date</th>
            <th>Comment</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="grade" items="${gradesAllForTeacher}">
            <c:url var="deleteButton" value="/teacherDeleteGrade">
                <c:param name="gradeId" value="${grade.id}"/>
            </c:url>
            <c:url var="updateButton" value="/teacherUpdateGrade">
                <c:param name="gradeId" value="${grade.id}"/>
            </c:url>
            <tr>
                <td>${grade.subject.title}</td>
                <td>${grade.student.firstName} ${grade.student.lastName}</td>
                <td>${grade.grade}</td>
                <td>${grade.datecurrent}</td>
                <td>${grade.comment}</td>
                <td>
                    <input type="button" value="update" class="button button_update" onclick="window.location.href='${updateButton}'"/>
                    <input type="button" value="delete" class="button button_delete" onclick="window.location.href='${deleteButton}'"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</security:authorize>
<security:authorize access="hasRole('STUDENT')">
    <input type="button" value="Show all grades" class="button button_show" onclick="window.location.href='student-all-grades'">
    <img src="/resources/img/oxford.png" class="img">
</security:authorize>
</body>
</html>
