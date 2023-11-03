<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name =request.getParameter("name");
	String age =request.getParameter("age");
	String gender =request.getParameter("gender");
	String[] coffee =request.getParameterValues("coffee");
	String coffeee="";
	for(String i : coffee){
		coffeee+=i+ " ";
	}
	String job =request.getParameter("job");
	String travel =request.getParameter("travel");
%>
이름 : <%=name %>
나이 : <%=age %>
성별 :  <%=gender %>
좋아하는 커피 : <%=coffeee %>
직업 :   <%=job %>
여행하고 싶은 나라 :  <%=travel %>





