<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta  charset="UTF-8">
<title>商品詳細</title>
</head>
<body>

	<div id="main">
		<p>商品詳細</p>
	</div>
	<div>
		<span>商品名</span>
		<s:property value="dto.getProductNameKana()" /><br>
		<s:property value="dto.getProductName()"/>
		<span>値段</span>
		<s:property value="dto.getPrice()" />
		<span>円</span><br>
		<span>発売会社名</span>
		<s:property value="dto.getReleaseDate()"/>
		<span>発売年月日</span>
		<s:property value="dto.getReleaseCompany()" />
		<a href="<s:url action="CartAction"><s:param name="productId" value="dto.getProductId()"/></s:url>">カートへ</a>
	</div>
</body>
</html>