<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <table border=1>
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
		
		<br><br>
		
		<jsp:useBean id="bb" class="mypkg.bookbean"/>
		<jsp:setProperty property="*" name="bb"/>
		
	
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
				<c:if test="${ bb.kind !== null }">
					<td>${ bb.kind }</td>
				</c:if>
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
		
		<br><br>
		
		<c:set var="bb2" value="<%= new mypkg.bookbean() %>"/>
		<c:set target="${ bb2 }" property="title" value="${ param.title }"/>
		<c:set target="${ bb2 }" property="author" value="${ param.author }"/>
		<c:set target="${ bb2 }" property="publisher" value="${ param.publisher }"/>
		<c:set target="${ bb2 }" property="price" value="${ param.price }"/>
		<c:set target="${ bb2 }" property="buy" value="${ param.buy }"/>
		<c:set target="${ bb2 }" property="kind" value="${ param.kind }"/>
		<c:set target="${ bb2 }" property="count" value="${ param.count }"/>
		
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
				<c:if test="${bb2.kind != null }">
					<td>${ bb2.kind }</td>
				</c:if>
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