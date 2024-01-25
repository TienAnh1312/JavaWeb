<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Detail</title>
</head>
<body>
    <h2>Customer Detail</h2>
    <c:if test="${not empty customer}">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>User name</th>
                <th>Name</th>
                <th>Email</th>
               
            </tr>
            <tr>
                <td>${customer.cusID}</td>
                <td>${customer.cusUser}</td>
                <td>${customer.cusName}</td>
                <td>${customer.cusEmail}</td>
            </tr>
        </table>
    </c:if>

    <p><a href="${pageContext.request.contextPath}/customerList">Back to Customer List</a></p>

</body>
</html>