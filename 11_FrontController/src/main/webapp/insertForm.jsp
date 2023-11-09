<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
insertForm.jsp<br>
<%
	application.setAttribute("flag", false);
%>
<h2>회원가입</h2>
<form action="insert.do" method="post">
   아이디<input type="text" name="id">
   비밀번호<input type="password" name="passwd">
   이름<input type="text" name="name">
   <input type="submit" name="가입하기">

</form>