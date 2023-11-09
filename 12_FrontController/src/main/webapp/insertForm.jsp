<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h2>영화 선호도 조사 </h2>
<%
	application.setAttribute("flag", false);
%>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
   $(function() {
      
      $('input[name="id"]').focus();
      
       var isBlank = false;   // 아이디가 공백일때
       var use = "";         // 아이디의 유효성검사
       var isCheck = false;   // 아이디의 유효성검사 유/무
       
       $('#idCheck').click(function(){
          
          isCheck = true;
          
          var checkId = $('input[name="id"]').val();
          // checkId변수에 input name이 id의 value값을 넣어준다
          
          if(checkId == ""){
             alert('아이디를 입력하셔야합니다');
             isBlank = true;
             return;
          }
          
          isBlank = false;
          
          $.ajax({
            url : "id.mv",
            data : ({
               userid : checkId
            }),
            success : function(data){
               // alert("data:"+data);
               if($.trim(data)=='YES'){
                  $('#idmessage').html("<font color=blue>사용가능한 아이디 입니다</font>");
                  $('#idmessage').show();
                  use = "possible";
               } else {
                  $('#idmessage').html("<font color=red>이미 사용중인 아이디 입니다</font>");
                  $('#idmessage').show();
                  use = "impossible";
               }
            }
          });
          
       }); // 아이디 중복검사 버튼클릭
      
       $("input[name=id]").keydown(function(){
          // alert('키보드 누름');
          isCheck = false;
          use="";
          $('#idmessage').css('display','none');
       });
       
       $('#sub').click(function(){
             if(use == "impossible"){
                alert("이미 사용중인 아이디입니다.");
                return false;
             } else if (isCheck == false) {
                alert("중복체크를 하셔야합니다!");
                return false;
             }
             else if(isBlank == true){
               alert('아이디를 입력하셔야합니다');
               return false;
            }
          });
       
   });
   
   function check(){
      
      if($('input[name="id"]').val()=="") {
         alert('아이디를 입력하세요');
         $('input[name="id"]').focus();
         return false;
      }
      
      if($('input[name="name"]').val()=="") {
         alert('이름을 입력하세요');
         $('input[name="name"]').focus();
         return false;
      }
      
      if($('input[name="age"]').val()=="") {
         alert('나이를 입력하세요');
         $('input[name="age"]').focus();
         return false;
      }
      
      if(isNaN($('input[name="age"]').val())){
         alert('나이는 숫자로 입력하세요');
         $('input[name="age"]').select();
         return false;
      }
      
      if (!$('input[name="genre"]').is(":checked")) {
         alert('장르 최소하나는 선택하셔야합니다');
         $('input[name="genre"]').focus();
         return false;
      }
      
      if (!$('input[name="partner"]').is(':checked')) {
         alert('동반인원을 선택해주세요');
         $('input[name="partner"]').focus();
         return false;
      }
      
   }
   
</script>
	<form action="insert.mv" method="post" name="myform">
		<table border="1">
		<tr>
			<td>아이디
			</td>
			<td>
				<input type="text" name="id" value="IU">
				<button type="button" id="id_check" onclick="">중복체크</button>
				<span id="idmessage" style="display:none;"></span>
			</td>  
		</tr>
		<tr>
			<td>이름</td><td> 
			<input type="text" name="name" value="아이유"></td> 
		</tr> 
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="23"></td> 
		</tr>
<tr>
			<td>좋아하는 장르</td>
			<td>
				<input type="checkbox" name="genre" value="공포">공포
				<input type="checkbox" name="genre" value="다큐">다큐 
				<input type="checkbox" name="genre" value="액션">액션 
				<input type="checkbox" name="genre" value="애니메이션">애니메이션
			</td> 
		</tr>

		<tr>
			<td>즐겨보는 시간대</td>
			<td>
				<select name="time">
					<option value="08~10">08~10</option>
					<option value="10~12">10~12</option>
					<option value="12~14">12~14</option>
					<option value="14~16">14~16</option>
					<option value="16~18">16~18</option>
					<option value="18~20">18~20</option>
				</select>
			</td> 
		</tr>
<tr>
			<td>동반 관객수</td>
			<td> 

				<%
				for(int i=1;i<=5;i++){
				%>
					<input type="radio" name="partner" value="<%=i%>"><%=i%>
				<%} %>
			</td>
		</tr>
		
		<tr>
			<td>영화관 개선사항</td>
			<td>
				<textarea name="memo" cols="40" rows="3">value는 여기에 넣기
				</textarea> 
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="가입하기" id="sub" onclick="return check()">
			</td>
		</tr>
		</table>
	</form>