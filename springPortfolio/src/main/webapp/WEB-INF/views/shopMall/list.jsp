<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %>

<c:set var="rowCounter" value="0"></c:set>
<c:set var="cellCounter" value="3"></c:set>
<c:set var="productSize" value="${fn:length(productList) }"></c:set>
<c:set var="imsiValue" value="${productSize / cellCounter }"></c:set>
<c:set var="imsiNamugi" value="${productSize % cellCounter }"></c:set>
<c:set var="productNum" value="0"></c:set>
<c:set var="productArray" value="${productList }"></c:set>

<c:choose>
	<c:when test="${imsiNamugi > 0 }">
		<c:set var="rowCounter" value="${imsiValue + 1 }"></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="rowCounter" value="${imsiValue }"></c:set>
	</c:otherwise>
</c:choose>


<table border="1">
	<c:forEach begin="1" end="${rowCounter }">
	<tr>
		<c:forEach begin="1" end="${cellCounter }">
			<c:choose>
				<c:when test="${productNum < productSize }">
					<td>
						<table border="0">
							<tr>
								<td colspan="2">
									<c:set var="attachArray" value="${fn:split(productArray[productNum].attachInfo, '|') }"></c:set>
									<c:set var="length" value="${fn:length(attachArray) }"></c:set>
									<c:set var="counter" value="0"></c:set>
									<c:choose> 
										<c:when test="${productArray[productNum].attachInfo == '-|-|-' }">
											[사진없음]
										</c:when>
										<c:otherwise>
											<c:forEach var="n" begin="0" end="${length - 1 }">
												<c:if test="${counter == 0 }">
													<c:choose>
														<c:when test="${attachArray[n] == '-'}"></c:when>
														<c:otherwise>
															<c:set var="imgArray" value="${fn:split(attachArray[n],',') }"></c:set>
																<a href="#" onclick="move('view','${productArray[productNum].productCode}');"><img src="${path }/attach${path}/product/${imgArray[1] }" alt="" style="width: 200px; height: 200px;"></img></a>
															<c:set var="counter" value="${counter + 1 }"></c:set>
														</c:otherwise>
													</c:choose>
												</c:if>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td>가격 :</td>
								<td align="right">${productArray[productNum].productPrice} 원</td>
							</tr>
						</table>	
					</td>
					<c:set var="productNum" value="${productNum + 1 }"></c:set>
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>
			</c:choose>	
		</c:forEach>
	</tr>
	</c:forEach>
</table> 

<script>
	function move(val1, val2){
		location.href = "${path}/shopMall/" + val1 + "?productCode_=" + val2;
	}
</script>