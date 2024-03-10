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
            <form method="POST" action="${pageContext.request.contextPath}/buitienanh_DEPARTMENT_Edit">
                <table class="table table-bordered">
                    <tr>
                        <td><label for="PublisherId">Mã nhà xuất bản</label></td>
                        <td><input type="text" id="PublisherId" name="PublisherId" value="${publishers.PublisherId}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="PublisherName">Tên nhà xuất bản</label></td>
                        <td><input type="text" id="PublisherName" name="PublisherName" value="${publishers.PublisherName}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="Phone">Số điện thoại</label></td>
                        <td><input type="text" id="Phone" name="Phone" value="${publishers.Phone}" /></td>
                    </tr>
                    
                    <tr>
                        <td><label for="Address">Địa chỉ</label></td>
                        <td><input type="text" id="Address" name="Address" value="${publishers.Address}" /></td>
                    </tr>
                           
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Ghi Lai" class="btn btn-success" /><a href="publisher_List" class="btn btn-danger">Quay Lai</a>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
    </section>
</body>
</html>