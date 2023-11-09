<%@page import="suv.SurveyBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
	<tr>
	<td>번호</td>
	<td>이름</td>
	<td>소속회사</td>
	<td>이메일 주소</td>
	<td>과정 만족도</td>
	<td>관심분야</td>
	<td>정보 발송 방법</td>
	<td>정보 발송 동의</td>
	<td>삭제</td>
	<td>수정</td>
	</tr>

	<c:forEach var="sv" items="${lists}">
	<tr>
	<td>${sv.no}</td>
	<td>${sv.name}</td>
	<td>${sv.company}</td>
	<td>${sv.email}</td>
	<td>${sv.satisfaction}</td>
	<td>${sv.part}</td>
	<td>${sv.howto}</td>
	<td>
	<c:if test="${sv.agree eq '1'}">
	동의
	</c:if> 
	<c:if test="${not(sv.agree eq '1')}">
	동의 안함
	</c:if> 
	
	</td>
	<td><a href="delete.sv?no=${sv.no}">삭제</a></td>
	<td><a href="updateForm.sv?no=${sv.no}">수정</a></td>
	</tr>
	</c:forEach>
	
</table>