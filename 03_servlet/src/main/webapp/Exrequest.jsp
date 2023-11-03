<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
function movePage() {
	alert("1");
	location.href="Request.do";
}
</script>
<a href="Request.do">링크</a>

<input type="button" value="요청" onclick="movePage()">

<form action="Request.do" method="get">
<input type="submit" value="get방식요청" onclick="movePage()">
</form>

<form action="Request.do" method="post">
<input type="submit" value="post방식요청" onclick="movePage()">
</form>
<!-- 
Get방식
웹브라우저의 주소표시줄에 직접 url을 입력하는 경우
a태그 통한 요청 
-->