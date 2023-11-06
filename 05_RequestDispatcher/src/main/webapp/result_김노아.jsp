<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 아이디 : <%=request.getParameter("id")%>
비번 : <%=request.getParameter("password")%>
이름 : <%=request.getParameter("name")%>
생년월일 : <%=request.getAttribute("birth")%>
취미 : <%=request.getAttribute("hbs")%>
C언어 :<%=request.getParameter("C")%>
JAVA :<%=request.getParameter("JAVA")%>
JSP:<%=request.getParameter("JSP")%>

<%
String[] arr = request.getParameterValues("hobby");
String[] arr1= (String[])request.getAttribute("rhobby");
%>
<c:forEach var="i" items="${arr }">
${i}
</c:forEach>
<c:forEach var="i" items="${arr1 }">
${i}
</c:forEach>

id4 = ${requestScope.id}

<c:forEach var="i" items="${requestScope.rhobby }" varStatus="status">
${i}
<c:if test="${status.last == false }">,</c:if>
</c:forEach>

<c:forEach var="i" items="${requestScope.eb.hobby }" varStatus="status">
${i}
<c:if test="${status.last == false }">,</c:if>
</c:forEach>

