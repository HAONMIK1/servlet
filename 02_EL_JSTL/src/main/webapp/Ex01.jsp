<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello
<%
out.print("hello");
%>
<script type="text/javascript">
	document.write('hello');	
</script>
<br>${"<br>"}
${"hello"}<br>
${"3+4"}= ${3+4} <br>
${3+4 == 7}<br>
${3+4 eq 7}<br>
${3+4 != 7}<br>
${8 ne 7}<br>

</body>
</html>