<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_include/inc_header.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${title }</h2>
<form name="DirForm">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="2">
			<button type="button" onclick="login();">로그인</button>
			<button type="button" onclick="location.href='${path}/member/chuga'">회원가입</button>
			</td>
		</tr>
	
	</table>
</form>
<script>
	function login(){
		var f = document.DirForm;
		f.action = "${path }/member/loginProc";
		f.method= "post";
		f.submit();
	}
</script>
</body>
</html>