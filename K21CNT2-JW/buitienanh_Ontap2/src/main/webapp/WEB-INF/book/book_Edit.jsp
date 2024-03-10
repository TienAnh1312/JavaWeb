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
            <form method="POST" action="${pageContext.request.contextPath}/book_Edit">
                <table class="table table-bordered">
                    <tr>
                        <td><label for="BookId">Mã sách</label></td>
                        <td><input type="text" id="BookId" name="BookId" value="${books.BookId}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="Title">Tiêu đề</label></td>
                        <td><input type="text" id="Title" name="Title" value="${books.Title}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="Author">Tác giả</label></td>
                        <td><input type="text" id="Author" name="Author" value="${books.Author}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="Release">Release</label></td>
                        <td><input type="text" id="Release" name="Release" value="${books.Release}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="Price">Giá</label></td>
                        <td><input type="text" id="Price" name="Price" value="${books.Price}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="Picture">Ảnh</label></td>
                        <td><input type="text" id="Picture" name="Picture" value="${books.Picture}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="PublisherId">Mã nhà xuất bản</label></td>
                        <td><input type="text" id="PublisherId" name="PublisherId" value="${books.PublisherId}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="CategoryId">Mã loại</label></td>
                        <td><input type="text" id="CategoryId" name="CategoryId" value="${books.CategoryId}" /></td>
                    </tr>                   
                    
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Ghi Lai" class="btn btn-success" /><a href="book_List" class="btn btn-danger">Quay Lai</a>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
    </section>
</body>
</html>