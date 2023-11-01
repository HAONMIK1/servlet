<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
국어 :${param.kor}<br>
영어	:${param.eng}<br>
수학 :${param.math}<br>
<%
int a = 10;
%>
<c:set var="aa" value="<%=a %>" />
aa: ${aa}
<br>
<c:set var="kor" value="${param.kor}" />
국어 :${kor}
<br>
<c:set var="sum" value="${param.kor+param.eng+param.math}" />
합 : ${sum}
<br>
<c:set var="avg" value="${sum/3}" />
평균 : ${avg}
<br>

<c:if test="${avg>=90}">
A학점
</c:if>
<c:if test="${avg>=80 and avg<90}">
b학점
</c:if>
<c:if test="${avg>=70 && avg <80}">
c학점
</c:if>

<c:choose>
	<c:when test="${avg>=90}">A</c:when>
	<c:when test="${avg>=80 and avg<90}">B</c:when>
	<c:when test="${avg>=70 && avg <80}">C</c:when>
	<c:otherwise>F</c:otherwise>
</c:choose>















