<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create teacher</h1>
<form:form action="saveContact" modelAttribute="teacher">
    <form:hidden path="id"/>
    <div>
        <form:input path="firstName" placeholder="first name"/>
    </div>
    <div>
        <form:input path="lastName" placeholder="last name"/>
    </div>
    <div>
        <input type="date" name="age" placeholder="Birth date" value="${teacher.age}"/>
    </div>
    <div>
        <form:input path="phone" placeholder="phone name"/>
    </div>
    <div>
        <form:input path="email" placeholder="e-mail"/>
    </div>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
