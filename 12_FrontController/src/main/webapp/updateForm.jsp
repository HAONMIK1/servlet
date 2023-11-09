<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2>영화 선호도 조사 수정 </h2>
<%
	application.setAttribute("flag", false);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" type="text/javascript" href="script.js">

	<form action="update.mv?num=${mb.num }" method="post" name="myform">
		<table border="1">
		<tr>
			<td>아이디
			</td>
			<td>
				<input type="text" name="id" value="${mb.id }">
				<button type="button" id="id_check">중복체크</button>
				<span id="idmessage" style="display:none;"></span>
			</td>  
		</tr>
		<tr>
			<td>이름</td><td> 
			<input type="text" name="name" value="${mb.name }"></td> 
		</tr> 
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="${mb.age}"></td> 
		</tr>
<tr>
			<td>좋아하는 장르</td>
			<%
				String[] genres = {"공포","다큐","액션","애니메이션"};	
				request.setAttribute("genres", genres);
			%>
			<td>
				<c:forEach var="i" items="${genres}">
				
				<input type="checkbox" name="genre" value="${i }" <c:if test="${fn : contains(mb.genre,i) }"> checked</c:if> >${i }
				</c:forEach>
<!-- 				<input type="checkbox" name="genre" value="공포">공포
				<input type="checkbox" name="genre" value="다큐">다큐 
				<input type="checkbox" name="genre" value="액션">액션 
				<input type="checkbox" name="genre" value="애니메이션">애니메이션
 -->			</td> 
		</tr>

		<tr>
			<%
				String[] time = {"08~10","10~12","12~14","14~16","16~18","18~20"};	
				request.setAttribute("time", time);
			%>
			<td>즐겨보는 시간대</td>
			<td>
				<select name="time">
				<c:forEach var="i" items="${time}">
					<option value="${i }"<c:if test="${ i eq mb.time }">selected</c:if>>${i }</option>
				
				</c:forEach>
<!-- 					 <option value="08~10" >08~10</option>
					<option value="10~12">10~12</option>
					<option value="12~14">12~14</option>
					<option value="14~16">14~16</option>
					<option value="16~18">16~18</option>
					<option value="18~20">18~20</option> -->
				</select>
			</td> 
		</tr>
<tr>
			<td>동반 관객수</td>
			<td> 

				<%
				for(int i=1;i<=5;i++){
				%>
					<input type="radio" name="partner" value="<%=i%>" <c:if test="${mb.partner == i }"> checked</c:if>><%=i%>
				<%} %>
			</td>
		</tr>
		
		<tr>
			<td>영화관 개선사항</td>
			<td>
				<textarea name="memo" cols="40" rows="3">${mb.memo }
				</textarea> 
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="수정하기" id="sub">
			</td>
		</tr>
		</table>
	</form>