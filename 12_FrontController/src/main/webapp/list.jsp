<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table border="1">
<tr>
<td><input type="radio"></td>
<td>번호</td>
<td>아이디</td>
<td>이름</td>
<td>나이</td>
<td>좋아하는 장르</td>
<td>즐겨보는 시간대</td>
<td>동반관객수</td>
<td>개선사항</td>
<td>수정</td>
<td>삭제</td>
</tr>
<c:forEach var="mv" items="${lists}">
<tr>
<td><input type="radio"></td>
<td>${mv.num }</td>
<td>${mv.id }</td>
<td>${mv.name }</td>
<td>${mv.age }</td>
<td>${mv.genre }</td>
<td>${mv.time }</td>
<td>${mv.partner }</td>
<td>${mv.memo }</td>
<td><a href="updateForm.mv?num=${mv.num}">수정</a></td>
<td><a href="delete.mv?num=${mv.num}">삭제</a></td>
</tr>
</c:forEach>
</table>