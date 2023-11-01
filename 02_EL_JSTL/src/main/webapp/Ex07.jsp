<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    	String[] movielist ={"30일","유토피아","베니스유령","소년들"};
    	pageContext.setAttribute( "mList", movielist);
    	
    	
    	for(int i =0 ; i< movielist.length;i++){
    		out.print(movielist[i]);
    	}
    	
    	for(String i : movielist){
    		out.print(i);
    		
    	}
    %>
<br>
<br>
<table border="1" width="400"  >
  <tr>
    <th>index</th>
    <th>count</th>
    <th>movie</th>
  </tr>
<c:forEach var="i" items="<%=movielist %>" varStatus="status">
  <tr>
    <td>${status.index }</td>
    <td>${status.count }</td>
    <td>${i}</td>
  </tr>
</c:forEach>
</table>
<c:forEach var="i" items="${mList}">
${i}
</c:forEach>
<br>
배열 방의 개수 :${fn:length(mList)}<br>
<c:forEach begin="1" end="${fn:length(mList)-1}" var="i">
${i} : ${mList[i]}<br>
</c:forEach>
<br>

<c:forEach var="i" begin="1" end="10" varStatus="a">
${i} /${a.first} /${a.last} / ${a.begin} /${a.end}  
<c:if test="${not a.last}">,</c:if><br>
</c:forEach>



















