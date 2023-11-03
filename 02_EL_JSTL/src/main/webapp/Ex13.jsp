<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="price" value="12345"/>
<c:out value="${price }"/>
<br>
<fmt:formatNumber value="${price}" type="currency" currencySymbol="원" />
<fmt:formatNumber value="${price}" type="percent"/><br>
<fmt:formatNumber value="${price}" type="number"/><br>

<fmt:formatNumber value="${price}" pattern="000,000.00"/><br>
<fmt:formatNumber value="${price}" pattern="###,###.##"/><br>

<fmt:formatNumber var="su1" value="123.78789" maxFractionDigits="1" /><br>
${su1}
<fmt:parseNumber var="su2" value="123.78789" integerOnly="true" />
${su2}











