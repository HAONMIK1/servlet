 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% 
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String[] fruit = request.getParameterValues("fruit");
String fruits="";
if(fruit.length==0){
	fruits="선택한 과일없음";
}else{
for(String i : fruit){
	fruits += i+" ";
	
}}
pageContext.setAttribute("fr",fruit);
%>
<br>
이름<%=name %><br>
과일<%=fruits %><br>
주소 ${paramValues.fruit}<br>
방 개수 ${fn : length(paramValues.fruit)}<br>       
<c:set var="flen" value="${fn : length(paramValues.fruit)}"></c:set>
<c:forEach begin="0" end="${fn : length(paramValues.fruit)-1}" var="i">
${fr[i]}
<%-- <c:if test="${not flen.last}"> ,</c:if> --%>
<c:if test="${ i != (flen - 1)}"> ,</c:if>
</c:forEach>

<br>

<c:forEach  var="i" items="${fr}" varStatus="a">
${i}
<c:if test="${not a.last}"> ,</c:if>

</c:forEach>