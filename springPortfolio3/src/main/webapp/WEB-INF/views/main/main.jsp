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
		<input type="text">
		<%@ include file="../_include/inc_menu.jsp" %>
		</td>
	</tr>
	<tr>
		<td style="padding:20px 20px;" align="center" id="resultTd">
		<jsp:include page="../_home/index.jsp"/>
		</td>
	</tr>
	<tr>
		<td style="padding:20px 20px;" align="center">
		</td>
	</tr>
</table>

<script>


function moveUrl(val1,val2){
	if(val1 == null || val1 ==''){
		val1 = "_home";
	}
	if(val1 == null || val1 ==''){
		val2 = "index";
	}
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

</body>
</html>