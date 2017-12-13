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

	<div id="logo">
	<h1>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ</h1>
	</div>


	<ul>
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
			<a href="CartAction"><img src="./public/cart.jpg" alt="cart" border="0" class="template"></a>
		</li>
	</ul>

	<div class=bar>
		<s:form action="SearchAction">
			<input type="search" name="searchText" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
			<s:submit value="検索"/>
		</s:form>
	</div>
</div>


	<div id="main">
		<div id="top"></div>
		以下の情報を登録してよろしいですか？
		<s:form action="CompleteDestAction">
			<table>
				<tbody>
					<tr>
						<td><label>姓：</label></td>
						<td><s:property value="familyName" /></td>
						<td><label>名：</label></td>
						<td><s:property value="firstName" /></td>
						<td><label>姓かな：</label></td>
						<td><s:property value="familyNameKana" /></td>
						<td><label>名かな：</label></td>
						<td><s:property value="firstNameKana" /></td>
						<td><label>メールアドレス：</label></td>
						<td><s:property value="email" /></td>
						<td><label>電話番号：</label></td>
						<td><s:property value="telNumber" /></td>
						<td><label>住所：</label></td>
						<td><s:property value="userAddress" /></td>
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