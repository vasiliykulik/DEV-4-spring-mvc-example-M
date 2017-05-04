<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="align-items: center">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Position</th>
        <th>Salary</th>
    </tr>
    <%--В items - мы должны обратится к переменной, а не переменной контроллера--%>
    <c:forEach var="employee" items="${employees}" >
        <tr>
            <%--это наши объекты, а через точки мы обращаемся к getters of our objects--%>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
            <td>${employee.salary}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
