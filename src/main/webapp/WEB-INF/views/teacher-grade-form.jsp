<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create grade</h1>
<form:form action="teacherAddGrade" modelAttribute="grade">
    <form:hidden path="id"/>
    <div>
        <label>Student:</label>
        <select name="idStudent">
            <c:forEach items="${students}" var="stud">
                <option value="${stud.id}">${stud}</option>
            </c:forEach>
        </select>
<%--        <form:select path="idStudent" >--%>
<%--            <form:options items="${students}" itemValue="id"/>--%>
<%--        </form:select>--%>
    </div>
<%--    <div>--%>
<%--        <label>Subject:</label>--%>
<%--        <form:select path="subject" >--%>
<%--            <form:options items="${subjects}"/>--%>
<%--        </form:select>--%>
<%--    </div>--%>
    <div>
        <label>Date:</label>
        <input type="date" name="datecurrent" placeholder="Date" value="${grade.datecurrent}"/>
    </div>
    <div>
        <label>Grade:</label>
        <form:input path="grade" placeholder="grade"/>
    </div>
    <div>
        <label>Comment:</label>
        <form:input path="comment" placeholder="comment"/>
    </div>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
