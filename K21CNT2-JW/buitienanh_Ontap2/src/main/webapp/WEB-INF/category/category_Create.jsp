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
					<td>Mã Loại</td>			
					<td><input type="text" name="CategoryId" value="${categories.CategoryId}"/></td>
				</tr>
				
				<tr>
					<td>Tên Loại</td>
					<td><input type="text" name="CategoryName" value="${categories.CategoryName}"/></td>
				</tr>
				
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lai" class="btn btn-success"/>
						<a href="category_List" class="btn btn-danger">Quay lai</a>
					</td>
				</tr>				
			</table>
		</form>
</body>
</html>