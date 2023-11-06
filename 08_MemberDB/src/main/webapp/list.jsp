<%@page import="myPkg.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
list.jsp
pagecontext.setAttribute() : pageScope
request.setAttribute()		: requestScope
session.setAttribute()		: sessionScope
application.setAttribute()	: applicationScope
pagecontext< request < session < application 사용범위 넓어짐
<table border="1">
<tr>
<th>아이디</th>
<th>이름</th>
<th>비밀번호</th>
</tr>
<c:forEach var="mb" items="${list}" varStatus="status">
<tr>
<td>
${mb.id}
</td>
<td>
${mb.name}
</td>
<td>
${mb.password}
</td>
</tr>
</c:forEach>
</table>

<%
	ArrayList<MemberBean> lists = (ArrayList)request.getAttribute("list");/*   =><%=lists% > */
	pageContext.setAttribute("lists",lists); /* => ${pageScop.lists} */
%>



<table border="1">
<tr>
<th>아이디</th>
<th>이름</th>
<th>비밀번호</th>
</tr>
<c:forEach var="mb" items="${pageScope.lists }" varStatus="status">
<%-- <c:forEach var="mb" items="<%=lists %>" varStatus="status"> --%>
<tr>
<td>
${mb.id}
</td>
<td>
${mb.name}
</td>
<td>
${mb.password}
</td>
</tr>
</c:forEach>
</table>
