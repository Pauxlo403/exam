<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Home</h1>


<security:authorize access="hasRole('TEACHER')">
    <input type="button" value="Create new grade" onclick="window.location.href='teacherCreateGrade'"/>
</security:authorize>
<security:authorize access="hasRole('STUDENT')">
    <input type="button" value="Show all grades" onclick="window.location.href='student-all-grades'">
</security:authorize>
</body>
</html>
