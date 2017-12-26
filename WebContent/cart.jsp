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

<div class="logo">

<p class="a">カ</p><p class="b">ー</p><p class="c">ト</p>
</div>

 <s:if test="cartList.size() != 0">

  	<s:iterator value="cartList">
  		<table border=1>
  			<tr>
  				<th>カテゴリ</th>
  				<th>商品名</th>
  				<th>値段</th>
  				<th>発売会社名</th>
  				<th>発売年月日</th>
  				<th>削除</th>
  			</tr>
  			<tr>
  				<td><s:property value="getCategoryName()"/></td>
  				<td><s:property value="getProductName()"/>
					<img src="<s:property value="getImageFilePath()"/>" class="itemImage"></td>
				<td><s:property value="getPrice()" />円</td>
				<td><s:property value="getReleaseCompany()"/></td>
				<td><s:property value= "getReleaseDate()"/></td>
				<td><a class="delete" href="<s:url action="CartDeleteAction"><s:param name="productId" value="getProductId()" /></s:url>">削除</a></td>
  		</table>
	</s:iterator>
		<a class="button" href="<s:url action="BuyItemConfirmAction"></s:url>">購入</a>
 </s:if>
	<s:else>
		<a class="button" class="sub" href="<s:url action="GoHomeAction" />">HOMEへ</a>
	</s:else>


</body>
</html>