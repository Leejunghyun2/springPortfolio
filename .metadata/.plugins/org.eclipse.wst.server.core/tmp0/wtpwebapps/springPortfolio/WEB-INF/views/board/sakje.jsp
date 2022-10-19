<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_include/inc_header.jsp" %>     
<h2>${title }</h2>
<form name="DirForm">
<input type="hidden" name="no_" value="${dto.no }">
<input type="hidden" name="searchGubun" value="${dto.searchGubun }">
<input type="hidden" name="searchData" value="${dto.searchData }">
<input type="hidden" name="pageNumber_" value="1">
<input type="hidden" name="tbl" value="${dto.tbl }">
<table border="1" width="80%">
	<tr>
		<td>게시판</td>
		<td>${dto.tblName }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${dto.writer }</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${dto.email }</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${dto.subject }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>${dto.content }</td>
	</tr>
	<tr>
		<td>공지글</td>
		<td>
			<c:choose>
				<c:when test="${dto.noticeNo > 0}">
					공지글				
				</c:when>
				<c:otherwise>
					공지글아님
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td>비밀글</td>
		
		<td>
			<c:choose>
				<c:when test="${dto.secretGubun == 'T'}">
					비밀글				
				</c:when>
				<c:otherwise>
					비밀글아님
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="save();">등록하기</button>
			<button type="button" onclick="location.href = '${path}/board/board_list?tbl=${dto.tbl }';">목록으로</button>
		</td>
	</tr>
</table>
</form>
<script>
	function save(){
		if(confirm('삭제할까요?')){
			var f = document.DirForm;
			f.action = "${path}/board/sakjeProc";
			f.method = "post";
			f.submit();
		}		
	}
</script>