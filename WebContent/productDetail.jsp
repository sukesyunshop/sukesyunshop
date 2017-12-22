<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta  charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/product.css">
<title>商品詳細</title>
</head>
<body>

<!---------------ヘッダー -------------->
<div id="header">
	<a href="<s:url action="GoHomeAction"/>"><img src="./images/logo.png"></a>

	<!-- 検索バー -->
	<div class="bar">
		<s:form action="SearchAction" theme="simple">
				<s:select class="category" name="categoryId" list="cateList" listKey="categoryId" listValue="categoryName" />
				<input class="input"  type="search" name="searchText" placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
				<s:submit class="submit" value="検索"/>
		</s:form>
	</div>

	<!-- メニューリスト-->
	<ul id="menu">
			<s:if test="#session.loginFlag == 'true'">
				<li><a href="<s:url action='LogoutAction' />"><img src="./images/logout.png" alt="logout" border="0" class="template"></a></li>
				<li><a href="<s:url action='GoMyPageAction' />"><img src="./images/login.png" alt="mypage" border="0" class="template"></a></li>
			</s:if>
			<s:else>
				<li><a href="./login.jsp"><img src="./images/login.png" alt="login" border="0" class="template"></a></li>
			</s:else>
		<li>
			<a href="CartAction"> <img src="./images/cart.png" alt="cart" border="0" class="template"></a>
		</li>
	</ul>

</div>
<!------------ヘッダーここまで ------------>


<!--------- カテゴリーリスト --------->
		<ul id="category">
			<s:iterator value="cateList">
				<li><a href="<s:url action='SearchAction'><s:param name="categoryId" value="getCategoryId()"/></s:url>"><s:property value="getCategoryName()" /></a></li>
			</s:iterator>
		</ul>


<div id="main">
	<h1 class="a">商</h1><h1 class="b">品</h1><h1 class="c">詳</h1><h1 class="d">細</h1>
</div>

<!-- 商品詳細 -->
<ul class="list">
	<li class="image">
		<img src="<s:property value="dto.getImageFilePath()"/>"><br>
	</li>
	<li class="moji">
		<span>商品名</span>
		<s:property value="dto.getProductNameKana()" /><br>
		<s:property value="dto.getProductName()"/><br>
		<span>商品詳細</span>
		<s:property value="dto.getProductDescription()"/><br>
		<span>値段</span>
		<s:property value="dto.getPrice()" />円<br>
		<span>発売会社名</span>
		<s:property value="dto.getReleaseDate()"/><br>
		<span>発売年月日</span>
		<s:property value="dto.getReleaseCompany()" /><br>
		<div class="moveWrapper">
			<a class="moveItem" href="<s:url action="CartAction"><s:param name="productId" value="dto.getProductId()"/></s:url>">カート</a>
			<a class="moveItem" href="<s:url action="CatalogAction" /> ">戻る</a>
		</div>
	</li>
</ul>

<!-- 同じカテゴリーの商品 -->
<h3>同じカテゴリーの商品<s:property value="getCategoryName()"/></h3>
<ul class="minilist">
	<s:iterator value="miniList">
		<li>
			<span>商品名</span><br>
			<s:property value="getProductName()"/><br>
			<a href="<s:url action="ProductDetailAction"><s:param name="productId" value="getProductId()"/></s:url>">
				<img src="<s:property value="getImageFilePath()"/>" class="itemImage border">
			</a><br>

			<a href="<s:url action="ProductDetailAction"><s:param name="productId" value="getProductId()"/></s:url>">商品詳細</a>
		</li>
	</s:iterator>
</ul>

</body>
</html>