<%@page import="myPkg.PersonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 name : <%=request.getParameter("name")%>
age : <%=request.getParameter("age")%>
name2 : <%=request.getAttribute("name2")%>
<%
	int age =(Integer)request.getAttribute("age2");
%>
age2 : <%=request.getAttribute("age2")%>

<%
	PersonBean pb = (PersonBean)request.getAttribute("pb");
%>
name :<%=pb.getName() %>
age :<%=pb.getAge() %>
weight:<%=pb.getWeight()%>


