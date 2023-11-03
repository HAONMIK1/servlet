<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>회원가입</h2>
<form action="<%=request.getContextPath() %>/memReg" method="post"> 
	회원명<input type="text" name="name"><br>
	주소 <input type="text" name="addr"><br>
	전화번호<input type="text" name="tel"><br>
	취미<br>
	<input type="checkbox" name="hobby" value="운동">운동<br>
	<input type="checkbox" name="hobby" value="게임">게임<br>
	<input type="checkbox" name="hobby" value="영화감상">영화감상<br>

	<input type="submit" value="전송">
</form>   