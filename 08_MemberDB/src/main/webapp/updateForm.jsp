<%@page import="myPkg.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>수정</h3>

<form action="update.mb?id=${requestScope.mb.id}" method="post" name="myform">
   <table border="1" align="center" width="80%">
      <tr>
         <td>이름</td>
         <td><input type="text" name="name" value="${requestScope.mb.name}"></td>
      </tr>
      
      <tr>
         <td>비밀번호</td>
         <td><input type="text" name="password" value="${requestScope.mb.password}"></td>
      </tr>
      
      <tr>
         <td colspan="2">
         <input type="submit" value="수정">
         </td>
      </tr>
   
   </table>
</form>