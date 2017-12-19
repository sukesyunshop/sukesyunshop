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


<div id="header">

	<div id="logo">
	<h1>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ</h1>
	</div>


	<ul>
		<li>
			<s:if test="#session.loginFlag == 'true'">
				<a href="<s:url action='LogoutAction' />">ログアウト</a>
				<a href="<s:url action='GoMyPageAction' />">マイページ</a>
			</s:if>
			<s:else>
				<a href="<s:url action='MoveLoginAction'/>"><img src="./public/login.jpg" alt="login" border="0" class="template"></a>
			</s:else>
		</li>
		<li>
			<a href="CartAction"><img src="./public/cart.jpg" alt="cart" border="0" class="template"></a>
		</li>
	</ul>

	<div class=bar>
		<s:form action="SearchAction">
			<input type="search" name="searchText" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
			<s:submit value="検索"/>
		</s:form>
	</div>
</div>


<div id="main">
	<p>商品詳細</p>
</div>

<!-- 商品詳細 -->
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

<!-- 同じカテゴリーの商品 -->
<ul>
	<s:iterator value="miniList">
		<li>
				<span>同じカテゴリーの商品</span>
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