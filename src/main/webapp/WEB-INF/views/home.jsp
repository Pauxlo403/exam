<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Home</h1>


<security:authorize access="hasRole('TEACHER')">
    <input type="button" value="Create new grade" onclick="window.location.href='teacherCreateGrade'"/>
    <table>
        <tr>
            <th>Subject</th>
            <th>Student</th>
            <th>Grade</th>
            <th>Date</th>
            <th>Comment</th>
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
                    <input type="button" value="update" onclick="window.location.href='${updateButton}'"/>
                    <input type="button" value="delete" onclick="window.location.href='${deleteButton}'"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</security:authorize>
<security:authorize access="hasRole('STUDENT')">
    <input type="button" value="Show all grades" onclick="window.location.href='student-all-grades'">
</security:authorize>
</body>
</html>
