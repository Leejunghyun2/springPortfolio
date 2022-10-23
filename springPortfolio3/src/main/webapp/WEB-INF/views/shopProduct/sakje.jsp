<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %>
<form name="DirForm">
<input type="text" name="productCode_" value="${dto.productCode }">
<table border="1">
	<tr>
		<td>상품이름</td>
		<td>${dto.productName }</td>
	</tr>
	<tr>
		<td>상품가격</td>
		<td>${dto.productPrice }</td>
	</tr>
	<tr>
		<td>제조사이름</td>
		<td>
			${dto.vendorName }
		</td>
	</tr>
		<c:if test="${dto.attachInfo != '-|-|-' }">
			<tr>
				<td>상품이미지</td>
				<td>
					<c:set var="array" value="${fn:split(dto.attachInfo,'|') }"></c:set>
					<c:forEach var="n" items="${array }" >
						<c:set var="imgArray" value="${fn:split(n, ',') }"></c:set>
							<c:choose>
								<c:when test="${n == '-' }"></c:when>
								<c:otherwise>
									<img src="${path }/attach${path}/product/${imgArray[1] }" alt="" style="width: 100px; height: 100px;"></img>
								</c:otherwise>
							</c:choose>				
					</c:forEach>
				</td>
			</tr>
		</c:if>
	<tr>
		<td>상품등록일</td>
		<td>${dto.regiDate }</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="save();">삭제하기</button>
		</td>
	</tr>
</table>
</form>
<script>
	function save(){
		var f = document.DirForm;
		f.action = "${path}/shopProduct/sakjeProc";
		f.method = "post";
		f.submit();
	}
</script> 