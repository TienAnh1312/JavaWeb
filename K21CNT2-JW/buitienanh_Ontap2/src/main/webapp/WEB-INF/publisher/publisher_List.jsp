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
					<th>Mã nhà sản xuất</th>
					<th>Tên nhà sản xuất</th>
					<th>Số điện thoại</th>
					<th>Địa chỉ</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${publisher_List}" var="books">
				    <tr>
				        <td>${publishers.PublisherId}</td>
				        <td>${publishers.PublisherName}</td>
				        <td>${publishers.Phone}</td>
				        <td>${publishers.Address}</td>

				        <td><a href="publisher_Edit?code=${books.PublisherId}">Edit</a></td>
				        <td><a href="publisher_Delete?code=${books.PublisherId}">Delete</a></td>
				    </tr>
				</c:forEach>

			</tbody>
		</table>
		<a href="PublisherId_Create">Create</a>
	</section>
</body>
</html>