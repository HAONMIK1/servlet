<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	/* ServletContext flag =new ServletContext */
	application.setAttribute("flag", false);
%>
상품정보
<form action="insert.prd" method="post">

상품명 : <input type="text" name="name"> 
가격	 :	<input type="text" name="price"> 
<input type="submit" value="등록">
</form>
