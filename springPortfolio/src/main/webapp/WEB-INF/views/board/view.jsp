<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../_include/inc_header.jsp" %>     
<h2>${title }</h2>
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
</table>
<div style="border: 0px solid red; padding-top: 20px; width: 80%;" align="left">
	<table>
		<tr>
			<td>
				이전게시글
			</td>
			<td>
				<c:choose>
					<c:when test="${dto.preNo <= 0 }">
						이전 게시글이 없습니다.
					</c:when>
					<c:otherwise>
						<a href="#" onclick="move('view','${dto.preNo}')">${dto.preSubject }</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				다음게시글 
			</td>
			<td>
			<c:choose>
					<c:when test="${dto.nxtNo <= 0 }">
						다음 게시글이 없습니다.
					</c:when>
					<c:otherwise>
						<a href="#" onclick="move('view','${dto.nxtNo}')">${dto.nxtSubject }</a>
					</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table>
</div>	
<div style="border: 0px solid red; padding-top: 20px; width: 80%;" align="right">
		|
		<a href="${path }/member/list" >전체목록</a>
		|
		<a href="#" onclick="move('list','')">목록</a>
		|
		<a href="#" onclick="move('chuga','')">등록</a>
		|
		<a href="#" onclick="move('chuga','${dto.no}')">답변등록</a>
		|
		<a href="#" onclick="move('sujung','${dto.no }')">수정</a>
		|
		<a href="#" onclick="move('sakje','${dto.no }')">삭제</a>
		|
</div>
<script>
	function move(val1, val2){
		location.href = '${path }/board/' + val1 + '?tbl=${dto.tbl}&no_=' + val2  + "&pageNumber_=${dto.pageNumber_}&${dto.searchQuery}";
	}
</script>