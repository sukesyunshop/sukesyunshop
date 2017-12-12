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
			<img src="<s:property value="dto.getImageFilePath()"/>">

		<span>値段</span>
			<s:property value="dto.getPrice()" />
		<span>円</span><br>

		<span>発売会社名</span>
			<s:property value="dto.getReleaseDate()"/>

		<span>発売年月日</span>
			<s:property value="dto.getReleaseCompany()" />

		<a href="<s:url action="CartAction"><s:param name="productId" value="dto.getProductId()"/></s:url>">カートへ</a>
		<a href="<s:url action="CatalogAction" /> ">戻る</a>
	</div>

	<ul>
		<s:iterator value="miniList">
			<li>
				<span>同じカテゴリの商品</span>
  				<s:property value="getCategoryId()"/><br>
  				<span>商品名</span>
				<s:property value="getProductNameKana()" /><br>
				<s:property value="getProductName()"/><br>
				<img src="<s:property value="getImageFilePath()"/>">
			
				<a href="<s:url action="ProductDetailAction"><s:param name="productId" value="getProductId()"/></s:url>">商品詳細</a>
			</li>
		</s:iterator>
	</ul>

</body>
</html>