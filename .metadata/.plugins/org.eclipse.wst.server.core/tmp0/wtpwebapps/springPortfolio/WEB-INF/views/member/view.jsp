<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %> 
	<table border="1" width="80%">
		<tr>
			<td>아이디</td>
			<td>
				${dto.id }
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${dto.passwd }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>${dto.jumin1 }-${dto.jumin2 }******</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				${dto.phone1 }-${dto.phone2 }-${dto.phone3 }
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				${dto.email1 }@${dto.email2 }
			</td>
		</tr>
		<tr>
			<td >주소</td>
			<td>
				${dto.postcode }
				${dto.address }
				${dto.detailAddress }
				${extraAddress }
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${dto.regiDate }</td>
		</tr>
</table>
<div style="border: 0px solid red; padding-top: 20px; width: 80%;" align="left">
	<table>
		<tr>
			<td>
				이전회원 
			</td>
			<td>
				<c:choose>
					<c:when test="${dto.preNo <= 0 }">
						이전 회원이 없습니다.
					</c:when>
					<c:otherwise>
						<a href="#" onclick="move('view','${dto.preNo}')">${dto.preName }</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td>
				다음회원 
			</td>
			<td>
			<c:choose>
					<c:when test="${dto.nxtNo <= 0 }">
						다음 회원이 없습니다.
					</c:when>
					<c:otherwise>
						<a href="#" onclick="move('view','${dto.nxtNo}')">${dto.nxtName }</a>
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
		<a href="#" onclick="move('sujung','${dto.no }')">수정</a>
		|
		<a href="#" onclick="move('sakje','${dto.no }')">삭제</a>
		|
</div>
<script>
	function move(val1, val2){
		location.href = '${path }/member/' + val1 + '?no_=' + val2  + "&pageNumber_=${dto.pageNumber_}&${dto.searchQuery}";
	}
</script>

	
