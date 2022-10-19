<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %> 
<div style="border: 0px solid red; padding-top: 0px; width: 80%;" align="left">
<c:choose>
	<c:when test="${searchData == '' }">
  		전체목록 : ${totalRecord } 건
  	</c:when>
  	<c:otherwise>
  		검색어 '<font color="red" style="font-weight: bolder;">${searchData }</font>'(으)로 검색한 목록 ${totalRecord }건
  	</c:otherwise>
</c:choose> 
(${pageNumber } / ${totalPage })
</div>
	<table border="1" width="80%">
		<tr>
			<th>순번</th>
			<th>tbl</th>
			<th>작성자</th>
			<th>제목</th>
			<th>이메일</th>
			<th>조회수</th>
			<th>등록일</th>
			<th>refNo</th>
			<th>stepNo</th>
			<th>levelNo</th>
			<th>parentNo</th>
			<th>memberNo</th>
			<th>noticeNo</th>
			<th>ip</th>
			<th>secretGubun</th>
		</tr>
		<c:if test="${totalRecord == 0 }">
		<tr>
			<td colspan="20" style="width: 300px; height: 100px;" align="center">등록된 게시글이 없습니다.</td>
		</tr>
		</c:if>
		<c:forEach var="boardDto" items="${list }">
			<tr>
				<td>${boardDto.no }</td>
				<td>${boardDto.tblName }</td>
				<td>${boardDto.writer }</td>
				<td width="100px">
				<c:if test="${boardDto.stepNo > 1 }">
					<c:forEach var="i" begin="1" end="${boardDto.stepNo - 1 }" >
						&nbsp;&nbsp;
					</c:forEach>
					└
				</c:if>
				<a href="#" onclick="move('view','${boardDto.no}')">
					${boardDto.subject }
				</a>
				
				</td>
				<td>${boardDto.email }</td>
				<td>${boardDto.hit }</td>
				<td>${boardDto.regiDate}</td>
				<td>${boardDto.refNo }</td>
				<td>${boardDto.stepNo }</td>
				<td>${boardDto.levelNo }</td>
				<td>${boardDto.parentNo }</td>
				<td>${boardDto.memberNo }</td>
				<td>${boardDto.noticeNo }</td>
				<td>${boardDto.ip }</td>
				<td>${boardDto.secretGubun }</td>
			</tr>
		</c:forEach>
	</table>
<div style="border: 0px solid red; padding-top: 20px; width: 80%;" align="right">
		|
		<a href="${path }/board/list?tbl=${dto.tbl}">전체목록</a>
		|
		<a href="#" onclick="move('list','')">목록</a>
		|
		<a href="#" onclick="move('chuga','')">등록</a>
		|
</div>
<div style="height:50px; display:flex; justify-content: center; align-items: center; margin: 1rem 0px 1rem 0px">
   <form name="searchForm">
      <div style="display:flex; height:30px">
         <select name="searchGubun" id="searchGubun" style="width: 80px; text-overflow:ellipsis; border:0px">
            <option value="" selected >-선택-</option>
            <option value="writer"  <c:if test="${dto.searchGubun == 'writer' }">selected</c:if>>작성자</option>
            <option value="subject"  <c:if test="${dto.searchGubun == 'subject' }">selected</c:if>>제목</option>
            <option value="content"  <c:if test="${dto.searchGubun == 'content' }">selected</c:if>>내용</option>
            <option value="writer_subject_content"  <c:if test="${dto.searchGubun == 'writer_subject_content' }">selected</c:if> >작성자+제목+내용</option>
         </select>
         <input type="text"  name="searchData"  id="searchData" value="${dto.searchData }"
         style="border:1px solid lightgrey; border-left:0px; border-right:0px; outline: none" placeholder="입력하세요">
         <button type="button" onClick="search()" style="border:0">검색</button>
      </div>
   </form>
</div>
<c:if test="${totalRecord > 0 }">
	<div style="border: 0px solid red; padding-top: 0px; width: 80%;" align="center">
	<c:set var="totalBlock" value="${(totalPage / blockSize) - 1}"></c:set>
	<c:set var="val1" value="${(totalPage / blockSize)}"></c:set>
	<c:set var="val2" value="${(totalPage / blockSize)}"></c:set>
	
	<c:if test="${pageNumber > 1 }">
		<a href="#" onclick="goPage('1');">[첫페이지]</a>
	</c:if>
	<c:if test="${pageNumber <= 1 }">
		[첫페이지]
	</c:if>
	
	
	<c:if test="${block <= 0 }">
	[이전${blockSize }개]
	</c:if>
	<c:if test="${block > 0 }">
		<a href="#" onclick="goPage('${block * blockSize}')">[이전${blockSize }개]</a>
	</c:if>
	
	
		<c:forEach var="i" begin="1" end="${blockSize }" step="1" varStatus="status">
			<c:set var="imsiValue" value="${block * blockSize + i}"/>
			<c:if test="${totalPage - imsiValue >= 0 }">
				<c:if test="${imsiValue == pageNumber }">
					[${imsiValue }]
				</c:if>
				<c:if test="${imsiValue != pageNumber }">
					<a href="#" onclick="goPage('${imsiValue}');">[${imsiValue }]</a>
				</c:if>
			</c:if>
		</c:forEach>
		
		
	<c:if test="${block < totalBlock }">
		<a href="#" onclick="goPage('${block * blockSize + blockSize + 1}');">[다음${blockSize }개]</a>
	</c:if>
	<c:if test="${block >= totalBlock }">
		[다음${blockSize }개]
	</c:if>
	
	
	<c:if test="${pageNumber >= totalPage }">
		[끝페이지]
	</c:if>
	<c:if test="${pageNumber < totalPage }">
		<a href="#" onclick="goPage('${totalPage}');">[끝페이지]</a>
	</c:if>
	
	
	</div>
</c:if>
<script>
	function search() {
	    searchForm.action="${path}/board/search";
	    searchForm.method="post";
	    searchForm.submit();
	 }
	function move(val1, val2){
		location.href = '${path }/board/' + val1 + '?tbl=${dto.tbl}&no_=' + val2 +"&pageNumber_=${dto.pageNumber_}&${dto.searchQuery}";
	}
	function goPage(val1){
		location.href = '${path }/board/list?pageNumber_='+ val1 +'&${dto.searchQuery}';
	}
</script>