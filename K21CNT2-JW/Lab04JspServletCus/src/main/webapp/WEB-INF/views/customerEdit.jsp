<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Customer</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <h2>Edit Customer</h2>
    <p style="color: red;">${errorString}</p>
    
    <form action="customerUpdate" method="post">
        <input type="hidden" name="cusID" value="${customer.cusID}">
        
        <label for="cusUser">User name:</label>
        <input type="text" id="cusUser" name="cusUser" value="${customer.cusUser}" required>
        
        
        <label for="cusName">Name:</label>
        <input type="text" id="cusName" name="cusName" value="${customer.cusName}" required>
        <label for="cusPhone">Phone:</label>
        <input type="text" id="cusPhone" name="cusPhone" value="${customer.cusPhone}" required>
        <label for="cusEmail">Email:</label>
        <input type="text" id="cusEmail" name="cusEmail" value="${customer.cusEmail}" required>

        <input type="submit" value="Update">
    </form>
</body>
</html>