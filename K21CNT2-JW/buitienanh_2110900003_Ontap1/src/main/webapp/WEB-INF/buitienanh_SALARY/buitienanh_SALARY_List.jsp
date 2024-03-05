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
					<th>GRADE</th>
					<th>HIGH_SALARY</th>
					<th>LOW_SALARY</th>
				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${buitienanh_SALARY_GRADE_List}" var="book">
				    <tr>
				        <td>${salary.GRADE}</td>
				        <td>${salary.HIGH_SALARY}</td>
				        <td>${salary.LOW_SALARY}</td>
				      
				      
				        <td><a href="buitienanh_BookEdit?code=${department.GRADE}">Edit</a></td>
				        <td><a href="buitienanh_BookDelete?code=${department.GRADE}">Delete</a></td>
				    </tr>
				</c:forEach>

			</tbody>
		</table>
		<a href="buitienanh_SALARY_GRADE_Create">Create Product</a>
	</section>
</body>
</html>