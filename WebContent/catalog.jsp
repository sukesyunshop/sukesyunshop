<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧画面</title>
</head>
<body>


<div id="main">
	<p>商品一覧</p>
</div>
<ul>
	<s:iterator value="list">
		<li>
				<span>商品名</span>
				<s:property value="getProductNameKana()" /><br>
				<s:property value="getProductName()"/>
				<span>値段</span>
				<s:property value="getPrice()" />
				<span>円</span>
				<a href="<s:url action="ProductDetailAction"><s:param name="productId" value="getId()"/></s:url>">商品詳細</a>
		</li>
	</s:iterator>
</ul>

</body>
</html>