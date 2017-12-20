<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入情報確認画面</title>
</head>
<body>

	<div id="header">
		<h1>
			<span>す</span>け<span>し</span>ゅん<span>S</span>H<span>O</span>P
		</h1>

		<!-- メニューリスト-->
		<ul id="menu">
			<li><s:if test="#session.loginFlag == 'true'">
					<a href="<s:url action='LogoutAction' />">ログアウト</a>
					<a href="<s:url action='GoMyPageAction' />">マイページ</a>
				</s:if> <s:else>
					<a href="<s:url action='MoveLoginAction'/>"><img
						src="./public/login.jpg" alt="login" border="0" class="template"></a>
				</s:else></li>
			<li><a href="CartAction"> <img src="./public/cart.jpg"
					alt="cart" border="0" class="template"></a></li>
		</ul>

		<!-- 検索バー -->

		<div class="bar">
			<s:form action="SearchAction">
				<input class="input" type="search" name="searchText"
					placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$"
					title="半角英数　ひらがな　漢字" maxlength="16">

				<s:submit class="submit" value="検索" />

			</s:form>
		</div>
	</div>


	<div id="main">
		<div id="top"></div>
		以下の情報を登録してよろしいですか？
		<table>
			<tbody>
				<tr>
					<th>姓</th>
					<td><s:property value="familyName" />
				</tr>
				<tr>
					<th>名</th>
					<td><s:property value="firstName" />
				</tr>
				<tr>
					<th>姓かな</th>
					<td><s:property value="familyNameKana" />
				</tr>
				<tr>
					<th>名かな</th>
					<td><s:property value="firstNameKana" />
				</tr>
				<tr>
					<th>姓別</th>
					<td><s:property value="sexStr" />
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:property value="email" />
				</tr>
				<tr>
					<th>電話番号</th>
					<td><s:property value="telNumber" />
				</tr>
				<tr>
					<th>住所</th>
					<td><s:property value="userAddress" />
				</tr>

			</tbody>
		</table>
		<s:form action="CompleteDestAction">
			<input name="familyName" type="hidden"
				value="<s:property value='familyName' />" />
			<input name="firstName" type="hidden"
				value="<s:property value='firstName' />" />
			<input name="familyNameKana" type="hidden"
				value="<s:property value='familyNameKana' />" />
			<input name="firstNameKana" type="hidden"
				value="<s:property value='firstNameKana' />" />
			<input name="sex" type="hidden" value="<s:property value='sex' />" />
			<input name="email" type="hidden"
				value="<s:property value='email' />" />
			<input name="telNumber" type="hidden"
				value="<s:property value='telNumber' />" />
			<input name="userAddress" type="hidden"
				value="<s:property value='userAddress' />" />
			<button class="button4">登録完了</button>
		</s:form>
	</div>
</body>
</html>