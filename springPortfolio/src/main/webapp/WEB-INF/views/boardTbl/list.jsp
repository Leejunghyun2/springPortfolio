<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_include/inc_header.jsp" %> 
<h2>${title }</h2>
<table border="1" width="80%">
	<tr>
		<th>게시판순번</th>
		<th>tbl</th>
		<th>게시판이름 </th>
		<th>등록일</th>
		<th>비고</th>
	</tr>
	<c:forEach var="list" items="${list }">
	<tr>
		<td>${list.no }</td>
		<td>${list.tbl }</td>
		<td>${list.tblName }</td>
		<td>${list.regiDate }</td>
		<td>
			<a href="#" onclick="move('sujung','${list.no}')">[수정]</a>
			<a href="#" onclick="move('sakje','${list.no}')">[삭제]</a>
		</td>
	</tr>
	</c:forEach>
</table>
<div style="border: 0px solid red; padding-top: 20px; width: 80%;" align="right">
		|
		<a href="${path }/boardTbl/list">전체목록</a>
		|
		<a href="#" onclick="move('list','')">목록</a>
		|
		<a href="#" onclick="move('chuga','')">등록</a>
		|
</div>
<script>
	function move(val1, val2){
		location.href = '${path }/boardTbl/' + val1 + '?no_=' + val2;
	}
</script>