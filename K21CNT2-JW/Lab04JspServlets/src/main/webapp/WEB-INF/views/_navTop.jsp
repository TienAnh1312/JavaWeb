<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <style>
 *{
     margin: 0;
     padding: 0;
 }
 nav{
     background-color: #3478E5;
 }
 nav ul{
     display: flex;
     justify-content: flex-start;
     align-items: center;
     list-style: none;
 }
 nav ul li a{
     color: #fff;
     display: block;
     padding: 1rem;
     text-decoration: none;
 }
 nav ul li a:first-child a{
     padding-left: 0 !important;
 }
 nav ul li a:hover{
     color: yellow;
 }
</style>
<ul class="container">
    <li>
        <a href="${pageContext.request.contextPath}/home">Home</a>
    </li>
    <li>
         <a href="${pageContext.request.contextPath}/productList">Prduct List</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/userList">User List</a>
    </li>
   </ul>