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
					<th>Mã sách</th>
					<th>Tiêu đề</th>
					<th>Tác giả</th>
					<th>Release</th>
					<th>Giá</th>
					<th>Ảnh</th>
					<th>Mã sản xuất</th>
					<th>Mã loại</th>
				
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${books_List}" var="books">
				    <tr>
				        <td>${books.BookId}</td>
				        <td>${books.Title}</td>
				        <td>${books.Author}</td>
				        <td>${books.Release}</td>
				        <td>${books.Price}</td>
				        <td>${books.Picture}</td>
				        <td>${books.PublisherId}</td>
				        <td>${books.CategoryId}</td>
				       
				        <td><a href="book_Edit?code=${books.BookId}">Edit</a></td>
				        <td><a href="book_Delete?code=${books.BookId}">Delete</a></td>
				    </tr>
				</c:forEach>

			</tbody>
		</table>
		<a href="book_Create">Create Product</a>
	</section>
</body>
</html>