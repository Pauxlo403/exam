<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/resources/css/style.css" rel="stylesheet"/>
</head>
<body class="body flex">
<h1>Create grade</h1>
<form:form action="teacherAddGrade" modelAttribute="grade" cssClass="form grid">
    <input type="hidden" name="idGrade" value="${grade.id}">
    <p class="error">${errorMessage}</p>
    <div class="grid">
        <label>Student:</label>
        <select name="idStudent" class="select">
            <c:forEach items="${students}" var="stud">
                <option value="${stud.id}"
                        <c:if test="${stud.id == grade.student.id}">
                            <c:out value="selected=selected"/>
                        </c:if>>${stud}</option>
            </c:forEach>
        </select>
    </div>
    <div class="grid">
        <label>Subject:</label>
        <select name="idSubject" class="select">
            <c:forEach items="${subjects}" var="subj">
                <option value="${subj.id}"  <c:if test="${subj.id == grade.subject.id}">
                    <c:out value="selected=selected"/>
                </c:if>>${subj}</option>
            </c:forEach>
        </select>
    </div>
    <div class="grid">
        <label>Date:</label>

        <input type="date" name="datecurrent" placeholder="Date" value="${grade.datecurrent}"/>
        <form:errors cssClass="error" path="datecurrent"/>
    </div>
    <div class="grid">
        <label>Grade:</label>
        <form:input path="grade" placeholder="grade"/>
    </div>
    <div class="grid">
        <label>Comment:</label>
        <form:textarea path="comment" placeholder="comment" cssClass="textarea"/>
    </div>
    <input type="submit" value="Save" class="button button_save">
</form:form>
</body>
</html>
