<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/buyItemConfirm.css">
<title>決済確認画面</title>
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

	<!-- 決済確認画面内容 -->
	<div class="main">
		<h1 id="title">決済確認</h1>
		<!--宛先選択 -->
		<s:form method="post" action="BuyItemCompleteAction">
			<div class="destList">
				<s:iterator value="destDTOList" status="list">
					<input type="radio" name="destNum"
						value="<s:property value="#list.index"/>"
						id="<s:property value="#list.index"/>" checked>
					<label for="<s:property value="#list.index"/>"> 名前：<s:property
							value="getFamilyName()" escape="false" /> <s:property
							value="getFirstName()" escape="false" /><br> ふりがな：<s:property
							value="getFamilyNameKana()" escape="false" /> <s:property
							value="getFirstNameKana()" escape="false" /><br> アドレス：<s:property
							value="getEmail()" escape="false" /><br> 連絡先：<s:property
							value="getTelNumber()" escape="false" /><br> 送り先：<s:property
							value="getUserAddress()" escape="false" />
					</label>
				</s:iterator>
			</div>
			<p>
				宛先が未作成の場合は<a href='<s:url action="InputDestAction"/>'>新規宛先作成へ</a>
			</p>

			<p>以下の情報で購入しますか？</p>
			<!-- カート情報 -->
			<ul class="cartList">
				<s:iterator value="cartList">
					<li class="cartItem"><img class="itemImage" alt="image"
						src="<s:property value="getImageFilePath()" />">
						<ul class="cartItemInfoList">
							<li class="itemInfo">商品名：<s:property
									value="getProductName()" /></li>
							<li class="itemInfo">値段：<s:property value="getPrice()" />円
							</li>
							<li class="itemInfo">発売会社名:<s:property
									value="getReleaseDate()" /></li>
							<li class="itemInfo">発売年月日:<s:property
									value="getReleaseCompany()" /></li>
						</ul>
				</s:iterator>
			</ul>
			<!-- 購入ボタン -->
			<div class="Button">
				<s:submit class="button" value="購入" />
			</div>
			<div id="goCart">
				<a href='<s:url action="CartAction"/>'>カート一覧に戻る場合はこちら</a>
			</div>
		</s:form>
	</div>
</body>
</html>