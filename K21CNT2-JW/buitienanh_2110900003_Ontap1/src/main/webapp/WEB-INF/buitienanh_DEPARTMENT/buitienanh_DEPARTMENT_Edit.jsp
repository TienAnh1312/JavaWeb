<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="container">
        <h3>Product Edit</h3>
        <p style="color: red;">${errorString}</p>
        <c:if test="${empty department}">
            <a href="buitienanh_BookList">Quay Lai</a>
        </c:if>
        <c:if test="${not empty department}">
            <form method="POST" action="${pageContext.request.contextPath}/buitienanh_DEPARTMENT_Edit">
                <table class="table table-bordered">
                    <tr>
                        <td><label for="DEPT_ID">IdBook_2110900003</label></td>
                        <td><input type="text" id="DEPT_ID" name="DEPT_ID" value="${department.DEPT_ID}" /></td>
                    </tr>
                    <tr>
                        <td><label for="DEPT_NAME">DEPT_NAME</label></td>
                        <td><input type="text" id="DEPT_NAME" name="DEPT_NAME" value="${department.DEPT_NAME}" /></td>
                    </tr>
                    <tr>
                        <td><label for="DEPT_NO">DEPT_NO</label></td>
                        <td><input type="text" id="DEPT_NO" name="DEPT_NO" value="${department.DEPT_NO}" /></td>
                    </tr>
                    <tr>
                        <td><label for="LOCATION">Price_2110900003</label></td>
                        <td><input type="text" id="LOCATION" name="LOCATION" value="${department.LOCATION}" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Ghi Lai" class="btn btn-success" /><a href="buitienanh_DEPARTMENT_List" class="btn btn-danger">Quay Lai</a>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
    </section>
</body>
</html>