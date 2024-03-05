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
                        <td><label for="GRADE">GRADE</label></td>
                        <td><input type="text" id="GRADE" name="DEPT_ID" value="${salary.DEPGRADET_ID}" /></td>
                    </tr>
                    <tr>
                        <td><label for="HIGH_SALARY">HIGH_SALARY</label></td>
                        <td><input type="text" id="HIGH_SALARY" name="HIGH_SALARY" value="${salary.HIGH_SALARY}" /></td>
                    </tr>
                    <tr>
                        <td><label for="LOW_SALARY">LOW_SALARY</label></td>
                        <td><input type="text" id="LOW_SALARY" name="LOW_SALARY" value="${salary.LOW_SALARY}" /></td>
                    </tr>
                   
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Ghi Lai" class="btn btn-success" /><a href="buitienanh_SALARY_GRADE_List" class="btn btn-danger">Quay Lai</a>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
    </section>
</body>
</html>