<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/buitienanh_DEPARTMENT_Create">
			<table class="table table-bordered">
				<tr>		
					<td>EMP_ID</td>			
					<td><input type="text" name="EMP_ID" value="${employee.EMP_ID}"/></td>
				</tr>
				<tr>
					<td>EMP_NAME</td>
					<td><input type="text" name="EMP_NAME" value="${employee.EMP_NAME}"/></td>
				</tr>
				<tr>
					<td>EMP_NO</td>
					<td><input type="text" name="EMP_NO" value="${employee.EMP_NO}"/></td>
				</tr>
				<tr>
					<td>IMAGE</td>
					<td><input type="text" name="IMAGE" value="${employee.IMAGE}"/></td>
				</tr>
				<tr>
					<td>JOB</td>
					<td><input type="text" name="JOB" value="${employee.JOB}"/></td>
				</tr>
				
				<tr>
					<td>SALARY</td>
					<td><input type="text" name="SALARY" value="${employee.SALARY}"/></td>
				</tr>
				
				<tr>
					<td>DEPT_ID</td>
					<td><input type="text" name="DEPT_ID" value="${employee.DEPT_ID}"/></td>
				</tr>
				
				<tr>
					<td>MNG_ID</td>
					<td><input type="text" name="SALARY" value="${employee.MNG_ID}"/></td>
				</tr>
				
				
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lai" class="btn btn-success"/>
						<a href="buitienanh_EMPLOYEE_List" class="btn btn-danger">Quay lai</a>
					</td>
				</tr>				
			</table>
		</form>
</body>
</html>