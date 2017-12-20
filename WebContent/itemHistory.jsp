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

<!-- 購入履歴情報がなしの時の表示 -->
<s:if test="#session.loginId =='null'">

</s:if>
<s:else>

</s:else>


<p>☆購入履歴一覧ฅ(´-ω-`)ฅ☆</p>
	<ul>
		<s:iterator value="list">
			<li>商品名:<s:property value="getProductName()" /></li>
			<li>値段:<s:property value="getPrice()" /></li>
			<li>発売会社名:<s:property value="getCompanyName()" /></li>
			<li>発売年月日:<s:property value="getReleaseDate()" /></li>
			<li>商品画像<br><img src="<s:property value="getImageFilePath()" />"></li>
		</s:iterator>
	</ul>

	<a href="<s:url action="GoHomeAction"/>">ホームに戻る</a>
	<a href="<s:url action="ItemHistoryDeleteAction"/>">購入履歴一覧削除</a>

</body>
</html>