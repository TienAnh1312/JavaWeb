<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>Product list</h3>
		<p style="color: red;">${errorString}</p>
		<table class= "table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>EMP_ID</th>
					<th>EMP_NAME</th>
					<th>EMP_NO</th>
					<th>IMAGE</th>
					<th>JOB</th>
					<th>SALARY</th>
					<th>DEPT_ID</th>
					<th>MNG_ID</th>
				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${buitienanh_EMPLOYEE_GRADE_List}" var="book">
				    <tr>
				        <td>${employee.EMP_ID}</td>
				        <td>${employee.EMP_NAME}</td>
				        <td>${employee.EMP_NO}</td>
				        <td>${employee.IMAGE}</td>
				        <td>${employee.JOB}</td>
				        <td>${employee.SALARY}</td>
				        <td>${employee.DEPT_ID}</td>
				        <td>${employee.MNG_ID}</td>
				   
				      
				      
				        <td><a href="buitienanh_BookEdit?code=${employee.GRADE}">Edit</a></td>
				        <td><a href="buitienanh_BookDelete?code=${employee.GRADE}">Delete</a></td>
				    </tr>
				</c:forEach>

			</tbody>
		</table>
		<a href="buitienanh_EMPLOYEE_Create">Create Product</a>
	</section>
</body>
</html>