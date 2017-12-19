<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/catalog.css">
<title>商品一覧画面</title>
</head>
<body>



<!---------------ヘッダー -------------->
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

<!------------ヘッダーここまで ------------>


	<!-- 検索バー -->
	<div class="bar">
		<s:form action="SearchAction">
				<input class="input"  type="search" name="searchText" placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
				<s:submit class="submit" value="検索"/>
		</s:form>
	</div>
	</div>



<!--------- カテゴリーリスト --------->
		<ul id="category">
			<s:iterator value="cateList">
				<li><a href="<s:url action='SearchAction'><s:param name="categoryId" value="getCategoryId()"/></s:url>"><s:property value="getCategoryName()" /></a></li>
			</s:iterator>
		</ul>





<p><s:property value="emptyMessage"/></p>


<ul class="menu">
	<s:iterator value="list">
		<li>
				<img src="<s:property value="getImageFilePath()" />" class="itemImage" ><br>
				<span>カテゴリー</span>
					<s:property value="getCategoryId()" /><br>
				<span>商品名</span>
					<s:property value="getProductNameKana()" /><br>
					<s:property value="getProductName()"/>
				<span>値段</span>
					<s:property value="getPrice()" />
					<span>円</span>
				<a href="<s:url action="ProductDetailAction"><s:param name="productId" value="getProductId()"/></s:url>">商品詳細</a>
		</li>
	</s:iterator>
</ul>



<ul class="br">
	<s:iterator begin="1" end="listSize" status="i">
		<li>
			<a href="
				<s:url action="SearchAction">
					<s:param name='page' value="#i.count" />
					<s:param name='categoryId' value="categoryId" />
				</s:url>
			">
				<s:property value="#i.count" />
			</a>
		</li>
	</s:iterator>
</ul>

</body>
</html>