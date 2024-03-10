<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/book_Create">
			<table class="table table-bordered">
				<tr>		
					<td>Mã Sách</td>			
					<td><input type="text" name="BookId" value="${books.BookId}"/></td>
				</tr>
				
				<tr>
					<td>Tiêu đề</td>
					<td><input type="text" name="Title" value="${books.Title}"/></td>
				</tr>
				
				<tr>
					<td>Tác giả</td>
					<td><input type="text" name="Author" value="${books.Author}"/></td>
				</tr>
				
				<tr>
					<td>Release</td>
					<td><input type="text" name="Release" value="${books.Release}"/></td>
				</tr>
				
				<tr>
					<td>Giá</td>
					<td><input type="text" name="Price" value="${books.Price}"/></td>
				</tr>
				
				<tr>
					<td>Ảnh</td>
					<td><input type="text" name="Picture" value="${books.Picture}"/></td>
				</tr>
				
				<tr>
					<td>Mã nhà xuất bản</td>
					<td><input type="text" name="PublisherId" value="${books.PublisherId}"/></td>
				</tr>
				
				<tr>
					<td>Mã loại</td>
					<td><input type="text" name="CategoryId" value="${books.CategoryId}"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lai" class="btn btn-success"/>
						<a href="book_List" class="btn btn-danger">Quay lai</a>
					</td>
				</tr>				
			</table>
		</form>
</body>
</html>