<%@page import="mypkg.BookBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% 
request.setCharacterEncoding("UTF-8");
String[] bookstore = request.getParameterValues("bookstore");
String bookstores="";
if(bookstore.length==0){
	bookstores="선택한 과일없음";
}else{
for(String i : bookstore){
	bookstores += i+" ";
	
}}
pageContext.setAttribute("bs",bookstore);
%>


<table border=1>
	<c:if test="${empty param.title }"> title1 누락</c:if>
	<c:if test="${param.title ==null}">title2 누락</c:if>
	<c:if test="${param.title ==''}">title3 누락</c:if>

	<c:if test="${empty param.kind }"> kind1 누락</c:if>
	<c:if test="${param.kind ==null}">kind2 누락</c:if>
	<c:if test="${param.kind ==''}">kind3 누락</c:if>
	
	<c:if test="${empty paramvalues.bookstore }">bookstore1 누락</c:if>
	<c:if test="${paramvalues.bookstore ==null}">bookstore2 누락</c:if>
	<c:if test="${paramvalues.bookstore ==''}">bookstore3 누락</c:if>
	<tr>
		<td>제목</td>
		<td>${ param.title }</td>
	</tr>
	<tr>
		<td>저자</td>
		<td>${ param.author }</td>
	</tr>
	<tr>
		<td>출판사</td>
		<td>${ param.publisher }</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>${ param.price }</td>
	</tr>
	<tr>
		<td>입고일</td>
		<td>${ param.buy }</td>
	</tr>

	<tr>
		<td>배송비</td>
		<c:if test="${param.kind == null}">
			<td>배송비 누락</td>
		</c:if>
		<c:if test="${param.kind != null }">
			<td>${ param.kind }</td>
		</c:if>
	</tr>
	<c:set var="blen" value="${fn : length(paramValues.bookstore)}" />

	<tr>
		<td>구입가능서점</td>
		<td><c:forEach begin="0" end="${blen-1}" var="i">
							${bs[i]}
				<c:if test="${ i != (blen- 1)}"> ,</c:if>
			</c:forEach></td>
	</tr>
	<tr>
		<td>보유수량</td>
		<c:if test="${ param.count eq '선택' }">
			<td>보유수량 누락</td>
		</c:if>
		<c:if test="${ not(param.count eq '선택') }">
			<td>${ param.count }</td>
		</c:if>
	</tr>
</table>

<br>
<br>

<jsp:useBean id="bb" class="mypkg.BookBean" />
<jsp:setProperty property="*" name="bb" />


<table border=1>
	<tr>
		<td>제목</td>
		<td>${ bb.title }</td>
	</tr>
	<tr>
		<td>저자</td>
		<td>${ bb.author }</td>
	</tr>
	<tr>
		<td>출판사</td>
		<td>${ bb.publisher }</td>
	</tr>
	<tr>
		<td>가격</td>
		<c:if test="${ bb.price == 0 }">
			<td></td>
		</c:if>
		<c:if test="${ !(bb.price == 0) }">
			<td>${ bb.price }</td>
		</c:if>
	</tr>
	<tr>
		<td>입고일</td>
		<td>${ bb.buy }</td>
	</tr>

	<tr>
		<td>배송비</td>
		<c:if test="${ bb.kind == null}">
			<td>배송비 누락</td>
		</c:if>
		<c:if test="${ bb.kind != null }">
			<td>${ bb.kind }</td>
		</c:if>
	</tr>
	<tr>
	<td>구입가능 서점</td>
	<td>
	<c:forEach  var="i" items="${bs}" varStatus="a">
		${i}
<c:if test="${not a.last}"> ,</c:if>

</c:forEach>
	</td>
	</tr>

	<tr>
		<td>보유수량</td>
		<c:if test="${ bb.count eq '선택' }">
			<td>보유수량 누락</td>
		</c:if>
		<c:if test="${ not (bb.count eq '선택') }">
			<td>${ bb.count }</td>
		</c:if>
	</tr>
</table>

<br>
<br>

<c:set var="bb2" value="<%= new mypkg.BookBean() %>" />
<c:set target="${ bb2 }" property="title" value="${ param.title }" />
<c:set target="${ bb2 }" property="author" value="${ param.author }" />
<c:set target="${ bb2 }" property="publisher"
	value="${ param.publisher }" />
<c:set target="${ bb2 }" property="price" value="${ param.price }" />
<c:set target="${ bb2 }" property="buy" value="${ param.buy }" />
<c:set target="${ bb2 }" property="kind" value="${ param.kind }" />
<c:set target="${ bb2 }" property="count" value="${ param.count }" />

<table border=1>
	<tr>
		<td>제목</td>
		<td>${ bb2.title }</td>
	</tr>
	<tr>
		<td>저자</td>
		<td>${ bb2.author }</td>
	</tr>
	<tr>
		<td>출판사</td>
		<td>${ bb2.publisher }</td>
	</tr>
	<tr>
		<td>가격</td>
		<c:if test="${ bb2.price == 0 }">
			<td></td>
		</c:if>
		<c:if test="${ !(bb2.price == 0) }">
			<td>${ bb2.price }</td>
		</c:if>
	</tr>
	<tr>
		<td>입고일</td>
		<td>${ bb2.buy }</td>
	</tr>

	<tr>
		<td>배송비</td>
		<c:if test="${ bb2.kind == null}">
			<td>배송비 누락</td>
		</c:if>
		<c:if test="${!empty bb2.kind}">
			<td>${ bb2.kind }</td>
		</c:if>
	</tr>
	<tr>
	<td>구입가능서점</td>
		<td>
	<c:forEach var="i" items="${ bb.bookstore }">
		${i }
	</c:forEach>
		</td>
	</tr>
	<tr>
		<td>보유수량</td>
		<c:if test="${ bb2.count eq '선택' }">
			<td>보유수량 누락</td>
		</c:if>
		<c:if test="${ not (bb2.count eq '선택') }">
			<td>${ bb2.count }</td>
		</c:if>
	</tr>
</table>