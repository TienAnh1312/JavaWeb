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
        <h3>Edit</h3>
        <p style="color: red;">${errorString}</p>
        <c:if test="${empty books}">
            <a href="book_List">Quay Lai</a>
        </c:if>
        <c:if test="${not empty books}">
            <form method="POST" action="${pageContext.request.contextPath}/category_Edit">
                <table class="table table-bordered">
                    <tr>
                        <td><label for="CategoryId">Mã Loại</label></td>
                        <td><input type="text" id="CategoryId" name="CategoryId" value="${categories.CategoryId}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="CategoryName">Tên loại</label></td>
                        <td><input type="text" id="CategoryName" name="CategoryName" value="${categories.CategoryName}" /></td>
                    </tr>
                           
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Ghi Lai" class="btn btn-success" /><a href="category_List" class="btn btn-danger">Quay Lai</a>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
    </section>
</body>
</html>