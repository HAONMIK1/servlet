<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

company1 <%=request.getParameter("company")%>
company2 ${param.company}
company3 <%=application.getInitParameter("company")%>

actor1 <%=request.getParameter("actor")%>
actor2 ${param.actor}
actor3 <%=application.getInitParameter("actor")%>

company4 ${initParam.company}
actor4 ${initParam.actor}
<%
  config.getServletContext();
%>
