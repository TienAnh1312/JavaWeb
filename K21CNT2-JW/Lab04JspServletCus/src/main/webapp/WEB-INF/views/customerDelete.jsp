<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
    <h2>Delete Customer</h2>
    <p style="color: red;">${errorString}</p>
    
    <form action="customerDelete" method="post">
        <input type="hidden" name="cusID" value="${customer.cusID}">
        
        <p>Are you sure you want to delete customer ${customer.cusUser}?</p>

        <input type="submit" value="Delete">
    </form>
</body>
</html>