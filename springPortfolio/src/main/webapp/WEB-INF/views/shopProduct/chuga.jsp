<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>${title }</h2>
<%@ include file="../_include/inc_header.jsp" %>
<form name="DirForm">
<table border="1">
	<tr>
		<td>상품이름</td>
		<td><input type="text" name="productName"></td>
	</tr>
	<tr>
		<td>상품가격</td>
		<td><input type="text" name="productPrice_"></td>
	</tr>
	<tr>
		<td>제조사이름</td>
		<td>
			<select name="vendorCode">
				<c:forEach var="vendorList" items="${vendorList }">
					<option value="${vendorList.vendorCode }">${vendorList.vendorName }</option>
				</c:forEach>	
			</select>
		</td>
	</tr>
	<tr>
		<td>상품이미지</td>
		<td>
			<input type="file" name="file"><br>
			<input type="file" name="file"><br>
			<input type="file" name="file">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="save();">등록하기</button>
		</td>
	</tr>
</table>
</form>
<script>
	function save(){
		var f = document.DirForm;
		f.enctype = "multipart/form-data";
		f.action = "${path}/shopProduct/chugaProc";
		f.method = "post";
		f.submit();
	}
</script> 