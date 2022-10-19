<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_include/inc_header.jsp" %> 
<h2>${title }</h2>
<form name="DirForm">
<table border="1">
	<tr>
		<td>tbl</td>
		<td><input type="text" name="tbl"></td>
	</tr>
	<tr>
		<td>게시판이름</td>
		<td><input type="text" name="tblName"></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="save();">등록</button>
		</td>
	</tr>
</table>
</form>
<script>
	function save(){
		var f = document.DirForm;
		f.action = "${path}/boardTbl/chugaProc";
		f.method = "post";
		f.submit();
	}
</script>