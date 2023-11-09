<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
list.jsp ${fn : length(lists)}
<br>

<table border="1" width="80%">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>등록</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<c:forEach var="mf" items="${lists}">

		<tr>
			<td>${mf.num}</td>
			<td>${mf.id}</td>
			<td>${mf.passwd}</td>
			<td>${mf.name}</td>
			<td>${mf.register}</td>
			<td><a href="delete.do?num=${mf.num}">삭제</a></td>
			<td><a href="updateForm.do?num=${mf.num}">수정</a></td>
	</c:forEach>
</table>
	<table border="1" width="80%">
		<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>등록</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="i" begin="0" end="${fn : length(lists)-1}" step="1">
	
		<tr>
			<td>${lists[i].num}</td>
			<td>${lists[i].id}</td>
			<td>${lists[i].passwd}</td>
			<td>${lists[i].name}</td>
			<td>${lists[i].register}</td>
			<td><a href="delete.do?num=${lists[i].num}">삭제</a></td>
			<td><a href="updateForm.do?num=${lists[i].num}">수정</a></td>
	</c:forEach>

</table>
<a href="insertForm.jsp">등록</a>