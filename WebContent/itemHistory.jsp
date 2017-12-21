<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/itemHistory.css">
<title>購入履歴一覧画面</title>
</head>
<body>

<!---------------ヘッダー -------------->
<div id="header">
	<a href="<s:url action="GoHomeAction"/>"><img src="./images/logo.png"></a>

	<!-- 検索バー -->
	<div class="bar">
		<s:form action="SearchAction">
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
				<li><a href="<s:url action='MoveLoginAction'/>"><img src="./images/login.png" alt="login" border="0" class="template"></a></li>
			</s:else>
		<li>
			<a href="CartAction"> <img src="./images/cart.png" alt="cart" border="0" class="template"></a>
		</li>
	</ul>

</div>
<!------------ヘッダーここまで ------------>

<h1 class="title">☆購入履歴一覧ฅ(´-ω-`)ฅ☆</h1>

<!-- 購入履歴情報がなしの時の表示 -->
<s:if test="list.size() == 0">
	<h2>購入履歴情報が存在しません</h2>
</s:if>
<s:else>
	<ul class="purchaseHistoryList">
		<s:iterator value="list">
			<li class="purchaseHistoryItem">
				<img class="itemImage" src="<s:property value="getImageFilePath()" />">
				<ul class="itemInfoList">
					<li class="itemInfo">商品名:<s:property value="getProductName()" /></li>
					<li class="itemInfo">値段:<s:property value="getPrice()" /></li>
					<li class="itemInfo">発売会社名:<s:property value="getReleaseCompany()" /></li>
					<li class="itemInfo">発売年月日:<s:property value="getReleaseDate()" /></li>
				</ul>
			</li>
		</s:iterator>
	</ul>
</s:else>
<div class="moveWrapper">
		<a href="<s:url action="GoHomeAction" />" class="moveItem"><input type="submit" value="HOMEへ" id="submitArea"></a>
		<a href="<s:url action="ItemHistoryDeleteAction" />" class="moveItem"><input type="submit" value="購入履歴一覧削除" id="submitArea"></a>
</div>
</body>
</html>