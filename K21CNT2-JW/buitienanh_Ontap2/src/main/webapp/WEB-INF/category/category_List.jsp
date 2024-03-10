<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section>
<h3>list</h3>
		<p style="color: red;">${errorString}</p>
		<table class= "table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>Mã Loại</th>
					<th>Tên loại</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${category_List}" var="books">
				    <tr>
				        <td>${categories.CategoryId}</td>
				        <td>${categories.CategoryName}</td>

				        <td><a href="category_Edit?code=${books.CategoryId}">Edit</a></td>
				        <td><a href="category_Delete?code=${books.CategoryId}">Delete</a></td>
				    </tr>
				</c:forEach>

			</tbody>
		</table>
		<a href="category_Create">Create</a>
	</section>
</body>
</html>