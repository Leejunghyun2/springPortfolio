<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %>
<table border="1" width="80%">
	<tr>
		<td>상품이미지</td>
		<td>상품이름</td>
		<td>상품가격</td>
		<td>제조사이름</td>
		<td>등록일</td>
		<td>비고</td>
	</tr>
	<c:forEach var="productList" items="${list }">
	<c:set var="attachArray" value="${fn:split(productList.attachInfo, '|') }"></c:set>
	<c:set var="length" value="${fn:length(attachArray) }"></c:set>
	<c:set var="counter" value="0"></c:set>
		<tr>
			<td align="center">
				<c:choose>
					<c:when test="${productList.attachInfo == '-|-|-' }">
						[사진없음]
					</c:when>
					<c:otherwise>
						<c:forEach var="n" begin="0" end="${length - 1 }">
							<c:if test="${counter == 0 }">
								<c:choose>
									<c:when test="${attachArray[n] == '-'}"></c:when>
									<c:otherwise>
										<c:set var="imgArray" value="${fn:split(attachArray[n],',') }"></c:set>
											<img src="${path }/attach${path}/product/${imgArray[1] }" alt="" style="width: 100px; height: 100px;"></img>
										<c:set var="counter" value="${counter + 1 }"></c:set>
									</c:otherwise>
								</c:choose>
							</c:if>
						</c:forEach>
					</c:otherwise>
				</c:choose>			
			</td>
			<td>${productList.productName }</td>
			<td>${productList.productPrice }</td>
			<td>${productList.vendorName }</td>
			<td>${productList.regiDate }</td>
			<td>
				<a href="#" onclick="move('sujung','${productList.productCode}');">[수정]</a>
				<a href="#" onclick="move('sakje','${productList.productCode}');">[삭제]</a>
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
	function search() {
	    document.searchForm.action="${path}/shopProduct/search";
	    document.searchForm.method="post";
	    document.searchForm.submit();
	 }
	function goPage(val1){
		location.href = '${path }/shopProduct/list?pageNumber_='+ val1 +'&${dto.searchQuery}';
	}
	function move(val1, val2){
		location.href = '${path }/shopProduct/' + val1 + '?productCode_=' + val2;
	}
</script>