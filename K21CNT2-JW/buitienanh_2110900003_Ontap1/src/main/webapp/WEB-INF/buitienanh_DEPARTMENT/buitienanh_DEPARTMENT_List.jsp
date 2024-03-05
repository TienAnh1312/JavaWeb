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
		<h3>Product list</h3>
		<p style="color: red;">${errorString}</p>
		<table class= "table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>DEPT_ID</th>
					<th>DEPT_NAME</th>
					<th>DEPT_NO</th>
					<th>LOCATION</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${buitienanh_DEPARTMENT_List}" var="book">
				    <tr>
				        <td>${department.DEPT_ID}</td>
				        <td>${department.DEPT_NAME}</td>
				        <td>${department.DEPT_NO}</td>
				        <td>${department.LOCATION}</td>
				      
				        <td><a href="buitienanh_BookEdit?code=${department.DEPT_ID}">Edit</a></td>
				        <td><a href="buitienanh_BookDelete?code=${department.DEPT_ID}">Delete</a></td>
				    </tr>
				</c:forEach>

			</tbody>
		</table>
		<a href="buitienanh_DEPARTMENT_Create">Create Product</a>
	</section>
</body>
</html>