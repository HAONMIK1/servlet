<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bb" class="mypkg.bookbean" />
<jsp:setProperty property="*" name="bb"/>

<table border="1">
  <tr>
    <th>제목</th>
    <td><%=bb.getTitle() %></td>
  </tr>
  <tr>
     <th>저자</th>
    <td><%=bb.getTitle() %></td>
  </tr>
  <tr>
    <th>출판사</th>
    <td><%=bb.getTitle() %></td>
  </tr>
  <tr>
     <th>가격</th>
    <td><%=bb.getTitle() %></td>
  </tr>
  <tr>
    <th>입고일</th>
    <td><%=bb.getTitle() %></td>
  </tr>
  <tr>
     <th>배송비</th>
  <td><%=bb.getTitle() %></td>
  </tr>
  <tr>
     <th>보유수량</th>
   <td><%=bb.getTitle() %></td>
  </tr>
</table>
