<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<hr>

<fmt:formatNumber var="avg3" value="${avg }" maxFractionDigits="0"/>
avg3 : ${avg3 }
<br>
 <fmt:parseNumber var="avg4" value="${avg3/10 }" integerOnly="true"/>
avg4 : ${avg4 }
<br>
 
<c:choose>
   <c:when test="${avg4 == 9 or avg4 == 10}">
      A학점
   </c:when>
   <c:when test="${avg4 == 8 }">
      B학점
   </c:when>
   <c:when test="${avg4 == 7 }">
      C학점
   </c:when>
   <c:when test="${avg4 == 6 }">
       D학점
   </c:when>
   <c:otherwise>
      F학점
   </c:otherwise>

</c:choose>

<c:set var="now" value="<%=new java.util.Date() %>" />
now : ${now }
<br>
<fmt:formatDate value="${now }" type="both" dateStyle="full"  timeStyle="full"/><br>
<fmt:formatDate value="${now }" type="both" dateStyle="medium"  timeStyle="full"/><br>
<fmt:formatDate value="${now }" type="both" dateStyle="full"  timeStyle="medium"/><br>
<fmt:formatDate value="${now }" type="both" dateStyle="medium"  timeStyle="medium"/><br>
<fmt:formatDate value="${now }" type="both" dateStyle="short"  timeStyle="medium"/><br>
<fmt:formatDate value="${now }" type="both" dateStyle="short"  timeStyle="short"/><br>
<br>
<fmt:formatDate value="${now }" type="date" dateStyle="short"  timeStyle="short"/><br>
<fmt:formatDate value="${now }" type="time" dateStyle="short"  timeStyle="short"/><br>

<fmt:formatDate value="${now }" type="both" dateStyle="full"  timeStyle="full" pattern="YYYY-MM-dd hh:mm"/><br>









