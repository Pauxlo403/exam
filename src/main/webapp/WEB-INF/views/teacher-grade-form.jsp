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
    <input type="hidden" name="idGrade" value="${grade.id}">
    <p>${errorMessage}</p>
    <div>
        <label>Student:</label>
        <select name="idStudent">
            <c:forEach items="${students}" var="stud">
                <option value="${stud.id}"
                        <c:if test="${stud.id == grade.student.id}">
                            <c:out value="selected=selected"/>
                        </c:if>>${stud}</option>
            </c:forEach>
        </select>
<%--        <form:errors cssClass="error" path="student"/>--%>
    </div>
    <div>
        <label>Subject:</label>
        <select name="idSubject">
            <c:forEach items="${subjects}" var="subj">
                <option value="${subj.id}"  <c:if test="${subj.id == grade.subject.id}">
                    <c:out value="selected=selected"/>
                </c:if>>${subj}</option>
            </c:forEach>
        </select>
<%--        <form:errors cssClass="error" path="subject"/>--%>
    </div>
    <div>
        <label>Date:</label>

        <input type="date" name="datecurrent" placeholder="Date" value="${grade.datecurrent}"/>
        <form:errors cssClass="error" path="datecurrent"/>
    </div>
    <div>
        <label>Grade:</label>
        <form:input path="grade" placeholder="grade"/>
<%--        <form:errors cssClass="error" path="grade"/>--%>
    </div>
    <div>
        <label>Comment:</label>
        <form:input path="comment" placeholder="comment"/>
    </div>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
