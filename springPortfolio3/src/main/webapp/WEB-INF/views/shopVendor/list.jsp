<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %>
<table border="1" width="80%">
	<tr>
		<th>순번</th>
		<th>제조사이름</th>
		<th>등록일</th>
		<th>비고</th>
	</tr>
	<c:if test="${fn:length(list) == 0 }">
		<tr>
			<td colspan="7" style="width: 300px; height: 100px;" align="center">등록된 제조사가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="vendorDto" items="${list }">
		<tr>
			<td>${vendorDto.vendorCode }</td>
			<td>${vendorDto.vendorName }</td>
			<td>${vendorDto.regiDate }</td>
			<td>
				<a href="#" onclick="move('sujung','${vendorDto.vendorCode}')">[수정]</a>
				<a href="#" onclick="move('sakje','${vendorDto.vendorCode}')">[삭제]</a>
			</td>
		</tr>
	</c:forEach>
</table>
<div style="border: 0px solid red; padding-top: 20px; width: 80%;" align="right">
		|
		<a href="${path }/member/list">전체목록</a>
		|
		<a href="#" onclick="move('list','')">목록</a>
		|
		<a href="#" onclick="move('chuga','')">등록</a>
		|
</div> 
<script>
	function move(val1, val2){
		location.href = "${path}/shopVendor/"+val1+"?vendorCode_="+val2;
	}
</script>