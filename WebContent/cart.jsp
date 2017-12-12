<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>

 <div id="main">
  	<p>カート</p>
 </div>

 <s:if test="cartList.size() != 0">
 <ul>
  	<s:iterator value="cartList">
  		<li>
  				<span>カテゴリ</span>
  					<s:property value="getCategoryId()"/><br>
  				<span>商品名</span>
					<s:property value="getProductNameKana()" /><br>
					<s:property value="getProductName()"/><br>
					<img src="<s:property value="getImageFilePath()"/>">
				<span>値段</span>
					<s:property value="getPrice()" />
					<span>円</span><br>
				<span>発売会社名</span>
					<s:property value="getReleaseDate()"/>
				<span>発売年月日</span>
					<s:property value="getReleaseCompany()" />
				<a href="<s:url action="CartDeleteAction"><s:param name="productId" value="productId" /></s:url>">削除</a>
  		</li>
	</s:iterator>
 </ul>

 <a href="<s:url action="BuyItemConfirmAction"></s:url>">購入</a>
	</s:if>
	<s:else>
		<a href="<s:url action="GoHomeAction" />">HOMEへ</a>
	</s:else>

</body>
</html>