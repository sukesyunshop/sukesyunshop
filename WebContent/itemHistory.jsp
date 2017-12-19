<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
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

<p>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ<br>
     購入履歴一覧</p>
			<s:form>
				<tr>
					<td>商品名:</td>
					<td><s:property value="list.getProductName()" /></td>
				</tr>

				<tr>
					<td>値段:</td>
					<td><s:property value="list.getPrice()" /></td>
				</tr>
				<tr>
					<td>発売会社名:</td>
					<td><s:property value="list.getCompanyName()" /></td>
				</tr>
				<tr>
					<td>発売年月日:</td>
					<td><s:property value="list.getReleaseDate()" /></td>
				</tr>


				<button type="button" onclick="location.href='GoHomeAction'"value="jump">ホームに戻る</button><br>

				<button type="button" onclick="location.href='ItemHistoryAction'"value="jump">購入履歴一覧削除</button>

			</s:form>
</body>
</html>