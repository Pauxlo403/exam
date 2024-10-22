<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Upgade subjects:</h2>
    <h3>${selectedTeacher.firstName} ${selectedTeacher.lastName}</h3>
    <form:form action="saveContact" modelAttribute="teacher">
        <form:hidden path="id"/>
        <form:hidden path="firstName"/>
        <form:hidden path="lastName"/>
        <form:hidden path="age"/>
        <form:hidden path="phone"/>
        <form:hidden path="email"/>

        <c:forEach var="subject" items="${allSkills}">
            <div>
                <form:checkbox title="asdf" path="subjects" value="${subject}"/>${subject.title}
            </div>
        </c:forEach>
        <input type="submit" value="Save">
    </form:form >
</body>
</html>
