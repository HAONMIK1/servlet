<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
form.jsp<br>
<!-- http://localhost:8080/07_URL_Pattern/insert.do -->

<a href="insert.do">insert</a><br><br>

<a href="http://localhost:8080<%=request.getContextPath() %>/delete.do">delete</a><br><br>

<a href="http://localhost:8080/07_URLPattern/update.do">update</a><br><br>

<a href="<%=request.getContextPath() %>/select.do">select</a><br><br>