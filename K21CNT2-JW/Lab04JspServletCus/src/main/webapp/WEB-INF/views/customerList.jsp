<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title>Customer List</title>
</head>
<body>
    <h2>Customer List</h2>
    <p style="color: red;">${errorString}</p>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>User name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Edit</th>
            <th>Delete</th>
            <th>Chi tiết</th>
        </tr>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.cusID}</td>
                <td>${customer.cusUser}</td>
                <td>${customer.cusEmail}</td>
                <td>${customer.cusPhone}</td>
               <td><a href="customerEdit?cusID=${customer.cusID}">Edit</a></td>
        	   <td><a href="customerDelete?cusID=${customer.cusID}">Delete</a></td>
        	   <td><a href="customerDetail?cusID=${customer.cusID}">Chi tiết</a></td>
        	   
    
            </tr>
        </c:forEach>
    </table>
    <a href="customerCreate">Thêm Mới</a>
</body>
</html>