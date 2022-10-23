<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %>

<%-- 총 합계금액을 구하기위한 변수선언 --%>
<c:set var="sum" value="0"></c:set>
<form name="chkForm">
<table border="1" width="80%">
	<tr>
		<th><input type="checkbox" name="checkAll" id="checkAll"></th>
		<th>상품이미지</th>
		<th>상품명</th>
		<th>제조사</th>
		<th>상품가격</th>
		<th>상품수량</th>
		<th>합계</th>
		<th>regiDate</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<c:set var="productInfo" value="${fn:split(dto.productInfo, '/' ) }"></c:set>
	<c:set var="attachArray" value="${fn:split(dto.attachInfo, '|') }"></c:set>
	<c:set var="length" value="${fn:length(attachArray) }"></c:set>
	<c:set var="counter" value="0"></c:set>
		<tr>
			<td><input type="checkbox" name="chk" value="${dto.cartNo }" align="center"></td>
			<td>
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
			<c:set var="productInfoArray" value="${fn:split(dto.productInfo, '/') }"></c:set>
			<td>${productInfoArray[0]}</td>
			<td>${productInfoArray[2]}</td>
			
			<td>${productInfoArray[1]}</td><%-- 1개당 가격 --%>
			<td>${dto.amount }</td>
			<td>${productInfoArray[1] * dto.amount }원</td>
			<c:set var="sum" value="${sum + (productInfoArray[1] * dto.amount) }"></c:set>
			
			<td>${dto.regiDate}</td>
			
		</tr>
	</c:forEach>
		<tr>
			<td colspan="8" align="right">총합계금액: ${sum } 원</td>
		</tr>
</table>
<div style="border: 0px solid red; padding-top: 20px; width: 80%;" align="right">
		|
		<a href="#" onclick="location.href='${path}/shopMall/list';">장보러가기</a>
		|
		<a href="#" onclick="cartClearForm();">삭제</a>
		|
</div>	
	</form>
<script>
$(function(){
	$("#checkAll").click(function(){
		if($("#checkAll").prop("checked")){
			$("input[name=chk]").prop("checked",true);
		} else{
			$("input[name=chk]").prop("checked",false);
		}
	});
})//한번에 체크
function cartClearForm(){
	if(confirm('삭제할까요?')){
		document.chkForm.action = "${path}/shopCart/sakjeProc";
		document.chkForm.method = "post";
		document.chkForm.submit(); 
	}
}
</script>