<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>All students</h2>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
    </tr>
    <c:forEach var="student" items="${students}">
<%--        <c:url var="upgradeSkillsButton" value="/upgradeSkills">--%>
<%--            <c:param name="selectedTeacherId" value="${teacher.id}"/>--%>
<%--        </c:url>--%>
        <tr>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
<%--            <td><input type="button" value="+" onclick="window.location.href='${upgradeSkillsButton}'"/></td>--%>
        </tr>
    </c:forEach>
</table>
<input type="button" value="Create new" onclick="window.location.href='createContact'"/>
</body>
</html>
