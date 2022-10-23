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
<table border="1" width="80%">
	<tr>
		<td style="padding:20px 20px;">
		<%@ include file="../_include/inc_menu.jsp" %>
	</tr>
	<tr>
		<td style="padding:20px 20px;" align="center">
		<jsp:include page="../${folderName }/${fileName }.jsp"/>
	</tr>
	<tr>
		<td style="padding:20px 20px;" align="center">
		<jsp:include page="../_include/inc_bottom.jsp"/>
	</tr>
</table>
<div id="result">
</div>
</body>
</html>