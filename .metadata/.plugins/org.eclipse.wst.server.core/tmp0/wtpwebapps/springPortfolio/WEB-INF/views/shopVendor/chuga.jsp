<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %>
<form name="DirForm">
<table border="1">
	<tr>
		<td>제조사이름</td>
		<td><input type="text" name="vendorName"></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="save();">등록하기</button>
		</td>
	</tr>
</table>
</form>
<script>
	function save(){
		var f = document.DirForm;
		f.action = "${path}/shopVendor/chugaProc";
		f.method = "post";
		f.submit();
	}
</script> 