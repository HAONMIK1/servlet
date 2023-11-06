<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>회원 가입</h3>
<script>

   function insertData(){//함수 통해서 액션 설정한것
      document.myform.action="insert.mb";
      document.myform.submit();// 서브밋 누른것처럼 동작하라는 뜻
   }

</script>
<form action="" method="post" name="myform">
   <table border="1" align="center" width="80%">
      <tr>
         <td>이름</td>
         <td><input type="text" name="name"></td>
      </tr>
      
      <tr>
         <td>비밀번호</td>
         <td><input type="text" name="password"></td>
      </tr>
      
      <tr>
         <td colspan="2">
         <a href="#" onClick="insertData()">회원가입</a>
         </td>
      </tr>
   
   </table>
</form>