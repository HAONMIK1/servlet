<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 =  Integer.parseInt(request.getParameter("num2"));

	out.print(num1 +"+"+num2+"="+(num1+num2));
%>
<br>
${param.num1} + ${param.num2} = ${ param.num1+param.num2 }































