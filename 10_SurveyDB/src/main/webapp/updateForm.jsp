<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<form action="update.sv?no=${sb.no}" method="post">
	과정 만족도 설문<br> 아래 항목을 입력해 주세요.
	<P>

		<b>개인 정보 :</b><br> 이름 <input type="text" name="name"
			value="${sb.name }"><br> 소속 회사 <input type="text"
			name="company" value="${sb.company }"><br> 이메일 주소 <input
			type="text" name="email" value="${sb.email }"><br>
	<p>
		<%
		String[] satisfaction = { "매우만족", "만족", "보통", "불만족", "매우불만족" };
		request.setAttribute("satisfaction", satisfaction);
		%>
		<c:forEach var="s" items="${requestScope.satisfaction}">
			<input type="radio" name="satisfaction" value="${s}"
				<c:if test="${s eq sb.satisfaction}">checked</c:if>>${s}
	</c:forEach>
	<p>
		<b>관심있는 분야는 무엇입니까?</b><br>
		<%
		String[] part = { "JAVA", "Spring", "UML", "JDBC", "서블릿", "JSP" };
		request.setAttribute("part", part);
		%>
		<c:forEach var="p" items="${requestScope.part}">

			<input type="checkbox" name="part" value="${p}"
				<c:if test="${fn:contains(sb.part , p)}">checked</c:if>>${p}
	</c:forEach>
	<p>
		정보 발송 방법 <select name="howto">
			<option value="email">email
			<option value="우편" selected="selected">우편
		</select>
	<p>
		<input type="checkbox" name="agree" <c:if test="${sb.agree eq '1'}">checked</c:if> value="1">
		정보 발송에 동의합니다.<br> <input type="submit" value="수정">
</form>