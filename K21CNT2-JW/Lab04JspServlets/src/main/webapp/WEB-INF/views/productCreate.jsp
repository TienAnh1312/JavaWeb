<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_navTop.jsp"></jsp:include>
	<section class="container">
		<h3>Create Product</h3>
		<p style="color:red;">${errorString}</p>
		<form method="POST" action="${pageContext.request.contextPath}/productCreate">
			<table class="table table-bordered">
				<tr>
					<td>Code</td>
					<td><input type="text" name="code" value="${product.code}"/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="${product.name}"/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" value="${product.price}"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lai" class="btn btn-success"/>
						<a href="productList" class="btn btn-danger">Quay lai</a>
					</td>
				</tr>				
			</table>
		</form>
	</section>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>