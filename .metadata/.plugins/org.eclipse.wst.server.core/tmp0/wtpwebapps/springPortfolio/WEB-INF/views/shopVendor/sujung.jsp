<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %>
<form name="DirForm">
<input type="hidden" name="vendorCode_" value="${dto.vendorCode }">
<table border="1">
	<tr>
		<td>순번</td>
		<td>${dto.vendorCode }</td>
	</tr>
	<tr>
		<td>제조사이름</td>
		<td><input type="text" name="vendorName" value="${dto.vendorName }"></td>
	</tr>
	<tr>
		<td>등록일</td>
		<td>${dto.regiDate }</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="save();">수정하기</button>
		</td>
	</tr>
</table>
</form>
<script>
	function save(){
		var f = document.DirForm;
		f.action = "${path}/shopVendor/sujungProc";
		f.method = "post";
		f.submit();
	}
</script> 