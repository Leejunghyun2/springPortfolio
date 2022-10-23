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
		</td>
	</tr>
	<tr>
		<%--<td style="padding:20px 20px;" align="center" id="resultTd">--%>
		 <td align="center"><jsp:include page="../${folderName }/${fileName }.jsp"/></td>
	</tr>
	<tr>
		<td style="padding:20px 20px;" align="center">
		<jsp:include page="../_include/inc_bottom.jsp"/>
		</td>
	</tr>
</table>
<%-- ajax 테스트용 
<script>
function moveUrl(val1,val2){
		$.ajax({
	type	: "POST",
	url	    : '${path}/' + val1 + '/' + val2,
	data	: {	
	},
	
	success : function(result) {
		page = val1;
		//update board fromd data
		$("#resultTd").html(result);
	},
	error : function(e) {
	console.log(e);
	}
});
}
</script>
--%>
</body>
</html>