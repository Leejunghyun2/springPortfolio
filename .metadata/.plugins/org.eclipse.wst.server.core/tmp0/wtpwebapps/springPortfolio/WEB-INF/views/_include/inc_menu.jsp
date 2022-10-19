<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="inc_header.jsp" %>
<script src = "http://code.jquery.com/jquery-3.4.1.min.js" ></script>
<table border="0" align="center">
	<tr>
		<td colspan="100" align="right" style="padding: 5px 10px 10px;">
			 <c:choose>
			 	<c:when test="${sessionScope.sessionNo == null }">
				 	<a href="${path }/member/login">로그인</a>
			 	</c:when>
			 	<c:otherwise>
			 		${sessionScope.sessionName } 님
			 		<a href="${path }/member/logout">로그아웃</a>
			 	</c:otherwise>
			 </c:choose>
		</td>
	</tr>
	<tr align="center">
		<td style="padding: 0px 10px;" id="index">
			<a href="${path }">[HOME]</a>
		</td>
		<td style="padding: 0px 10px;" id="member">
			<a href="${path }/member/list">회원관리</a>
		</td>
		<td style="padding: 0px 10px;" id="board">
			<a href="${path }/board/list" >전체게시판</a>
		</td>
		<td style="padding: 0px 10px;" id="freeboard">
			<a href="${path }/board/list?tbl=freeboard" >자유게시판</a>
		</td>
		<td style="padding: 0px 10px;" id="onebyone">
			<a href="${path }/board/list?tbl=onebyone">1대1게시판</a>
		</td>
		<td style="padding: 0px 10px;" id="boardTbl"> 
			<a href="${path }/boardTbl/list">게시판관리</a>
		</td>
		<td style="padding: 0px 10px;" id="shopProduct">
			<a href="${path }/shopProduct/list">상품관리</a>
		</td>
		<td style="padding: 0px 10px;" id="shopVendor">
			<a href="${path }/shopVendor/list">제조사관리</a>
		</td>
		<td style="padding: 0px 10px;" id="shopMall">
			<a href="${path }/shopMall/list">쇼핑몰</a>
		</td>
		<td style="padding: 0px 10px;" id="shopCart">
			<a href="${path }/shopCart/list">장바구니</a>
		</td>
	</tr>
</table>

    