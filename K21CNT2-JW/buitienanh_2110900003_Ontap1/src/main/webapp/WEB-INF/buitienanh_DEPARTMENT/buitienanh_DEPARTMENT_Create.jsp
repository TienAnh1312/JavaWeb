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
					<td>DEPT_ID</td>			
					<td><input type="text" name="DEPT_ID" value="${department.DEPT_ID}"/></td>
				</tr>
				<tr>
					<td>DEPT_NAME</td>
					<td><input type="text" name="DEPT_NAME" value="${department.DEPT_NAME}"/></td>
				</tr>
				<tr>
					<td>DEPT_NO</td>
					<td><input type="text" name="DEPT_NO" value="${department.DEPT_NO}"/></td>
				</tr>
				<tr>
					<td>LOCATION</td>
					<td><input type="text" name="LOCATION" value="${department.LOCATION}"/></td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lai" class="btn btn-success"/>
						<a href="buitienanh_DEPARTMENT_List" class="btn btn-danger">Quay lai</a>
					</td>
				</tr>				
			</table>
		</form>
</body>
</html>