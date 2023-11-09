<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
updateForm.jsp<br>
<%
	application.setAttribute("flag", false);
%>
<h2>회원가입</h2>
<form action="update.do" method="post">
   아이디<input type="text" name="id" value="${mb.id }">
   비밀번호<input type="password" name="passwd" value="${mb.passwd }">
   이름<input type="text" name="name" value="${mb.name }">
   <input type="hidden" name="num" value="${mb.num }">
   <input type="submit" name="가입하기">

</form>