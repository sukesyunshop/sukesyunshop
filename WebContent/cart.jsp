<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/cart.css">
<title>Cart</title>


</head>
<body>


<div id="header">
	<h1><span>す</span>け<span>し</span>ゅん<span>S</span>H<span>O</span>P</h1>

<!-- メニューリスト-->
	<ul id="menu">
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
			<a href="CartAction"> <img src="./public/cart.jpg" alt="cart" border="0" class="template"></a>
		</li>
	</ul>

	<!-- 検索バー -->

	<div class="bar">
		<s:form action="SearchAction">
				<input class="input"  type="search" name="searchText" placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">

				<s:submit class="submit" value="検索"/>

		</s:form>
	</div>
</div>


<div class="logo">
<p>CART</p>
</div>



 <s:if test="cartList.size() != 0">
 <a href="<s:url action="BuyItemConfirmAction"></s:url>">購入</a>
 <ul class="menu">
  	<s:iterator value="cartList">
  		<li>
  				<span>カテゴリ</span>
  					<s:property value="getCategoryId()"/><br>
  				<span>商品名</span>
					<s:property value="getProductNameKana()" /><br>
					<s:property value="getProductName()"/><br>
					<img src="<s:property value="getImageFilePath()"/>" class="itemImage">
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

 </s:if>
	<s:else>
		<a class="sub" href="<s:url action="GoHomeAction" />">HOMEへ</a>
	</s:else>


</body>
</html>