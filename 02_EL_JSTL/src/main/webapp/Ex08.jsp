<%@page import="mypkg.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    
Ex08.jsp<br>

<%
	Book bk1 = new Book("EL&JSTL","아이유",2000);
	pageContext.setAttribute("bk11", bk1); // 속성명, 값
	out.println("bk1.getTitle():"+bk1.getTitle()+"<br>");
%>

\${bk1.title} : ${bk11.title}<br>  
c:out => <c:out value="${bk11.title}"/><br> 
<hr>

<!-- useBean bk2
myPkg.Book bk2 = new myPkg.Book();
bk2.setTitle("Spring"); -->
<jsp:useBean id="bk2" class="mypkg.Book"/>
<jsp:setProperty property="title" name="bk2" value="Spring"/>
<jsp:setProperty property="author" name="bk2" value="태연"/>
<jsp:setProperty property="price" name="bk2" value="3000"/>
<%
pageContext.setAttribute("bk22", bk2); // 속성명, 값
%>
\${bk2.title} : ${bk22.title}<br>  
c:out => <c:out value="${bk22.title}"/><br> 

<hr>
<!-- myPkg.Book bk3 = new myPkg.Book();
bk3.setTitle("자바") -->
<c:set var="bk3" value="<%=new mypkg.Book() %>"/>
<c:set target="${bk3}" property="title" value="자바"/>
<c:set target="${bk3}" property="author">윤아</c:set>
<c:set target="${bk3}" property="price" value="5000"/>

\${bk3.title} : ${bk3.title}<br>  
c:out => <c:out value="${bk3.title}"/><br> 





