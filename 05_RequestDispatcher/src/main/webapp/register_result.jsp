<%@page import="myPkg.CoffeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%
 	request.setCharacterEncoding("UTF-8");
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
<%
	CoffeeBean cb = (CoffeeBean)request.getAttribute("cb");
	out.print(cb.getName()+" "+cb.getCoffee());
	String name2 = (String)request.getAttribute("Cname");
	String[] coffee2 =  (String[])request.getAttribute("Ccoffee");
	for(String i : coffee2){
		out.print(i+" ");
	}	
%>

<c:forEach var="i" items="${requestScope.coffee}">
${i}
</c:forEach>

<c:forEach var="i" items="${requestScope.cb.coffee}">
${i}
</c:forEach>




