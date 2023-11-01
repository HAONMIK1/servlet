 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String age = request.getParameter("age");
	out.print(id +" "+name +" "+password+" "+age);
%>
<jsp:useBean id="pb" class="mypkg.PersonBean"/>
<jsp:setProperty property="*" name="pb"/>
<br><br>
아이디 :<%=id %><br>
이름  :<%=name %><br>
비밀번호:<%=password %><br>
나이	:<%=age %><br>
<br>
<br>
아이디 :<%=pb.getId() %><br>
이름  :<%=pb.getName() %><br>
비밀번호:<%=pb.getPassword() %><br>
나이	:<%=pb.getAge() %><br>
<br>
<br>
아이디 :<jsp:getProperty property="id" name="pb"/> <br>
이름  :<jsp:getProperty property="name" name="pb"/><br>
비밀번호:<jsp:getProperty property="password" name="pb"/><br>
나이	:<jsp:getProperty property="age" name="pb"/><br>
<br>
EL표기법
<br>
아이디 :${param.id}<br>
이름 : ${param.password}<br>
비밀번호 :${param['name']}<br>
나이 : ${param.age}<br>
<br>
<br>
아이디 :${pb.id}<br>
이름 : ${pb.password}<br>
비밀번호 :${pb['name']}<br>
나이 : ${pb.age}<br>
-----------------------
<br>id 비교1 <%=request.getParameter("id") == ("wendy") %>
<br>id 비교2 <%=request.getParameter("id").equals("wendy") %>
<br>id 비교3	${param.id =="wendy"}
<br>id 비교4	${param.id.equals( "wendy")}
<br>id 비교5	${ param.id eq "wenday"} 































