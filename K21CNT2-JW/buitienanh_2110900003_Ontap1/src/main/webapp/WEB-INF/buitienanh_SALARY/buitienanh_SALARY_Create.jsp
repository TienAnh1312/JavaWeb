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
					<td>GRADE</td>			
					<td><input type="text" name="GRADE" value="${salary.GRADE}"/></td>
				</tr>
				<tr>
					<td>HIGH_SALARY</td>
					<td><input type="text" name="HIGH_SALARY" value="${salary.HIGH_SALARY}"/></td>
				</tr>
				<tr>
					<td>LOW_SALARY</td>
					<td><input type="text" name="LOW_SALARY" value="${salary.LOW_SALARY}"/></td>
				</tr>
		
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lai" class="btn btn-success"/>
						<a href="buitienanh_SALARY_GRADE_List" class="btn btn-danger">Quay lai</a>
					</td>
				</tr>				
			</table>
		</form>
</body>
</html>