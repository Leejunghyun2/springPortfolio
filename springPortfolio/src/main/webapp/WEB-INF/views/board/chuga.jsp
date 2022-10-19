<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_include/inc_header.jsp" %>     
<h2>${title }</h2>
<form name="DirForm">
<input type="hidden" name="no" value="${dto.no }">
<input type="hidden" name="searchGubun" value="${dto.searchGubun }">
<input type="hidden" name="searchData" value="${dto.searchData }">
<input type="hidden" name="pageNumber_" value="1">
<input type="text" value="${dto.tbl }">
<table border="1" width="80%">
	<tr>
		<td>게시판종류</td>
		<td>
			<select name="tbl">
				<c:forEach var="tblList" items="${tblList }">
					<option value="${tblList.tbl }" <c:if test="${tblList.tbl == dto.tbl }">selected</c:if>>${tblList.tblName }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="subject" value="${dto.subject }"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="content" style="width: 300px; height : 100px;">${dto.content }</textarea></td>
	</tr>
	<c:if test="${dto.no == 0 }">
	<tr>
		<td>공지글</td>
		<td>
			<input type="radio" name="noticeGubun" value="T">공지글 &nbsp;
			<input type="radio" name="noticeGubun" value="F" checked>공지글아님 &nbsp;
		</td>
	</tr>
	</c:if>
	<tr>
		<td>비밀글</td>
		<td>
			<input type="radio" name="secretGubun" value="T">비밀글 &nbsp;
			<input type="radio" name="secretGubun" value="F" checked>비밀글아님 &nbsp;
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="save();">등록하기</button>
			<button type="button" onclick="location.href = '${path}/board/list';">목록으로</button>
		</td>
	</tr>
</table>
</form>
<script>
	function save(){
		if(confirm('등록할까요?')){
			var f = document.DirForm;
			f.action = "${path}/board/chugaProc";
			f.method = "post";
			f.submit();
		}		
	}
</script>