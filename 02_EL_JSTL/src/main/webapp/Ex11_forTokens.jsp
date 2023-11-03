<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="list" value="가나/디리*시/이" />
${list}<br>
<c:out value="${list}"/>
<br>
<c:forTokens var="oneItem" items="${list}" delims="/*" varStatus="status">
<c:out value="${status.index}"/>:
<c:out value="${oneItem}"/><br>
</c:forTokens>