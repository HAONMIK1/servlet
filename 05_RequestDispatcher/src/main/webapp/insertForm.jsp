<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="insert" method="post">
아이디 : <input type="text" name="id"><br><br>
비번 : <input type="password" name="password"><br><br>
이름 : <input type="text" name="name" > <br> <br>
생년월일 
<select name="birth1">
<c:forEach  var="i" begin="1900" end="2023" >
<option value="${i}">${i }</option>
</c:forEach>
</select>
년 
<select name="birth2"> 
<c:forEach  var="i" begin="1" end="12" >
<option value="${i }">${i }</option>
</c:forEach>
</select>
월 
<select name="birth3">
<c:forEach  var="i" begin="1" end="31" >
<option value="${i }">${i }</option>
</c:forEach>
</select>
일 <br>
<br>
<%
	String [] hb ={"탁구","펜싱","테니스"};
	pageContext.setAttribute("hb", hb);
%>
취미 : 
<c:forEach var="i" items="${hb}">
<input type="checkbox" name="hobby" value="${i}">${i}
</c:forEach>

<br> <br>
C언어: <input type="text" name="C" >
JAVA: <input type="text" name="JAVA">
JSP: <input type="text" name="JSP" ><br> <br>
<input type="submit" value="가입하기"><br>
</form>