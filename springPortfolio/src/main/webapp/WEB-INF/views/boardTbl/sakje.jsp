<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_include/inc_header.jsp" %> 
<h2>${title }</h2>
<form name="DirForm">
<input type="hidden" name="no_" value="${dto.no }">
<table border="1">
	<tr>
		<td>tbl</td>
		<td>${dto.tbl }</td>
	</tr>
	<tr>
		<td>게시판이름</td>
		<td>${dto.tblName }</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="save();">삭제</button>
		</td>
	</tr>
</table>
</form>
<script>
	function save(){
		var f = document.DirForm;
		f.action = "${path}/boardTbl/sakjeProc";
		f.method = "post";
		f.submit();
	}
</script>