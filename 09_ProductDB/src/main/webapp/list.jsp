<%@page import="prd.ProdBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<table border="1">
<tr>
<td>아이디</td>
<td>이름</td>
<td>단가</td>
<td>입고일자</td>
<td>수정</td>
<td>삭제</td>
</tr>
<c:forEach var="pb" items="${lists}" varStatus="status">
<tr>
<td>${pb.id}</td>
<td>${pb.name}</td>
<td>${pb.price}</td>
<td>${pb.regdate}</td>
<%-- <fmt:parseDate value="${pb.regdate}" var="reg"/>
<fmt:parseDate/> --%>
<td> <a href="updateForm.prd?id=${pb.id}">수정</a> </td>
<td> <a href="delete.prd?id=${pb.id}">삭제</a> </td>
</tr>
</c:forEach>
</table>
<a href="insertForm.jsp">등록</a>
