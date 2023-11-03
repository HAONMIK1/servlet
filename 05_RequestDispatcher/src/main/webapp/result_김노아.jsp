<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 아이디 : <%=request.getParameter("id")%>
비번 : <%=request.getParameter("password")%>
이름 : <%=request.getParameter("name")%>
생년월일 : <%=request.getAttribute("birth")%>
취미 : <%=request.getAttribute("hbs")%>
C언어 :<%=request.getParameter("C")%>
JAVA :<%=request.getParameter("JAVA")%>
JSP:<%=request.getParameter("JSP")%>