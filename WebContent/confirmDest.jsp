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
		<s:form action="CompleteDestAction">
			<input name="familyName" type="hidden" value="<s:property value='familyName' />" />
			<input name="firstName" type="hidden" value="<s:property value='firstName' />" />
			<input name="familyNameKana" type="hidden" value="<s:property value='familyNameKana' />" />
			<input name="firstNameKana" type="hidden" value="<s:property value='firstNameKana' />" />
			<input name="email" type="hidden" value="<s:property value='email' />" />
			<input name="telNumber" type="hidden" value="<s:property value='telNumber' />" />
			<input name="userAddress" type="hidden" value="<s:property value='userAddress' />" />

			<table>
				<tbody>
					<tr>
						<td><label>姓：</label></td>
						<td></td>
						<td><label>名：</label></td>
						<td><input type="text" name="firstName"
							value="<s:property value="firstName" />" disabled></td>
						<td><label>姓かな：</label></td>
						<td><input type="text" name="familyNameKana"
							value="<s:property value="familyNameKana" />" disabled></td>
						<td><label>名かな：</label></td>
						<td><input type="text" name="firstNameKana"
							value="<s:property value="firstNameKana" />" disabled></td>
						<td><label>メールアドレス：</label></td>
						<td><input type="text" name="email"
							value="<s:property value="email" />" disabled></td>
						<td><label>電話番号：</label></td>
						<td><input type="text" name="telNumber"
							value="<s:property value="telNumber" />" disabled></td>
						<td><label>住所：</label></td>
						<td><input type="text" name="userAddress"
							value="<s:property value="userAddress" />" disabled></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><s:submit class="button" value="完了" /></td>
					</tr>
				</tbody>
			</table>
		</s:form>
	</div>
</body>
</html>