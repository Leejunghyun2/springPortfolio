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
	
	<jsp:include page="../chart/dbChart.jsp" flush="true"></jsp:include>
	
	<a href="${path }/member/login">[로그인]</a>
	<a href="${path }/member/chuga">[회원가입]</a>
</body>
</html>