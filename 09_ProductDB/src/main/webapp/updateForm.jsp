<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
상품정보
<form action="update.prd?id=${requestScope.pb.id}" method="post">

상품명 : <input type="text" name="name" value="${pb.name }"> 
가격	 :	<input type="text" name="price" value="${pb.price }"> 
<input type="submit" value="등록">
</form>
