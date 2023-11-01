 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("UTF-8");
	int dan = Integer.parseInt(request.getParameter("dan"));
	for(int i =1;i<10;i++){
		out.println(dan+"x"+i+"="+(dan*i)+"<br>");
	}
%>
<br>
<c:forEach var="i"  begin="1" end="9">
	${param.dan} X ${i }=${param.dan*i}<br>
</c:forEach>






