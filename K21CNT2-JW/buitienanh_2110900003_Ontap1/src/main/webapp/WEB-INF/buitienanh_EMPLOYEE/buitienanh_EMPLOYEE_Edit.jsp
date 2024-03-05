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
                        <td><label for="EMP_ID">EMP_ID</label></td>
                        <td><input type="text" id="EMP_ID" name="EMP_ID" value="${employee.EMP_ID}" /></td>
                    </tr>
                    <tr>
                        <td><label for="EMP_NAME">EMP_NAME</label></td>
                        <td><input type="text" id="EMP_NAME" name="EMP_NAME" value="${employee.EMP_NAME}" /></td>
                    </tr>
                    <tr>
                        <td><label for="EMP_NO">EMP_NO</label></td>
                        <td><input type="text" id="EMP_NO" name="EMP_NO" value="${employee.EMP_NO}" /></td>
                    </tr>
                    
                     <tr>
                        <td><label for="IMAGE">IMAGE</label></td>
                        <td><input type="text" id="IMAGE" name="IMAGE" value="${employee.IMAGE}" /></td>
                    </tr>
                   
                   
                    <tr>
                        <td><label for="JOB">JOB</label></td>
                        <td><input type="text" id="JOB" name="JOB" value="${employee.JOB}" /></td>
                    </tr>
                    
                     <tr>
                        <td><label for="SALARY">SALARY</label></td>
                        <td><input type="text" id="SALARY" name="SALARY" value="${employee.SALARY}" /></td>
                    </tr>
                    
                     <tr>
                        <td><label for="DEPT_ID">DEPT_ID</label></td>
                        <td><input type="text" id="DEPT_ID" name="SALDEPT_IDARY" value="${employee.DEPT_ID}" /></td>
                    </tr>
                    
                     <tr>
                        <td><label for="MNG_ID">MNG_ID</label></td>
                        <td><input type="text" id="MNG_ID" name="MNG_ID" value="${employee.MNG_ID}" /></td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Ghi Lai" class="btn btn-success" /><a href="buitienanh_EMPLOYEE_List" class="btn btn-danger">Quay Lai</a>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
    </section>
</body>
</html>