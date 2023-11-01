 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
좋아하는 음식
<h1>
<c:set var="food" value="${param.food}"/>
${food}
</h1>

<c:if test="${param.food eq '피자'}">
피자먹자
</c:if>


<c:if test="${param.food eq '초밥'}">
초밥먹자
</c:if>

<c:if test="${not(param.food != '초밥' && param.food != '피자')}">
먹자
</c:if>
<c:if test="${param.food != '초밥' && param.food != '피자'}">
그만먹자
</c:if>
<c:if test="${param.food != '초밥' and param.food != '피자'}">
그만먹자
</c:if>
<br>
<br>
switch case
<c:choose>
	<c:when test="${param.food eq '초밥'}">먹자</c:when>
	<c:when test="${param.food eq '피자'}">먹자</c:when>
	<c:otherwise>
		그만먹어	
	</c:otherwise>
</c:choose>







