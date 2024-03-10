<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/category_Create">
			<table class="table table-bordered">
				<tr>		
					<td>Mã Nhà Xuất Bản</td>			
					<td><input type="text" name="PublisherId" value="${publishers.PublisherId}"/></td>
				</tr>
				
				<tr>
					<td>Tên Nhà Xuất Bản</td>
					<td><input type="text" name="PublisherName" value="${publishers.PublisherName}"/></td>
				</tr>
				
				<tr>
					<td>Số Điện Thoại</td>
					<td><input type="text" name="Phone" value="${publishers.Phone}"/></td>
				</tr>
				
				<tr>
					<td>Địa chỉ</td>
					<td><input type="text" name="Address" value="${publishers.Address}"/></td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lai" class="btn btn-success"/>
						<a href="publisher_List" class="btn btn-danger">Quay lai</a>
					</td>
				</tr>				
			</table>
		</form>
</body>
</html>