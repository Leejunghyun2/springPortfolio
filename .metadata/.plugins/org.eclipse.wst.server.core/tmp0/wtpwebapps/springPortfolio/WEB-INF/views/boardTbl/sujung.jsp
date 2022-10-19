<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_include/inc_header.jsp" %> 
<h2>${title }</h2>
<form name="DirForm">
<input type="hidden" name="no_" value="${dto.no }">
<table border="1">
	<tr>
		<td>tbl</td>
		<td><input type="text" name="tbl" value="${dto.tbl }"></td>
	</tr>
	<tr>
		<td>게시판이름</td>
		<td><input type="text" name="tblName" value="${dto.tblName }"></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="save();">수정</button>
		</td>
	</tr>
</table>
</form>
<script>
	function save(){
		var f = document.DirForm;
		f.action = "${path}/boardTbl/sujungProc";
		f.method = "post";
		f.submit();
	}
</script>