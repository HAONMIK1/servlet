<%@page import="myPkg.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="<%=request.getContextPath() %>/fserv" method="post"> 
	이름<input type="text" name="name"><br>
	나이<input type="text" name="age"><br>
	<input type="submit" value="전송">
</form>   
<!--
forward 액션태그는 request객체를 공유한다.
response.sendRedirect request객체를 공유하지 않는다. 
forward 최종페이지의 주소가 거쳐가는 페이지가 된다.
response는 최종페이지의 주소가 최종페이지이다. 

JSP에서는 중간에 거쳐가는 페이지에서
response.sendRedirect: RD.forward() 같지 않다. 값을 못받는다.
or 
jsp:forward: RD.forward()랑 같다. 값을 받는다.
-->