<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <title>Create Customer</title>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
</head>
<body>
    <h2>Create Customer</h2>
    <form action="${pageContext.request.contextPath}/customerCreate" method="post">
        <!-- Form fields for customer information -->
        User name: <input type="text" name="cusUser" required><br>
        Name: <input type="text" name="cusName" required><br>
        Email: <input type="text" name="cusEmail" required><br>
        Phone: <input type="text" name="cusPhone" required><br>
        Password: <input type="password" name="cusPass" required><br>
        <input type="submit" value="Create Customer">
    </form>
</body>
</html>