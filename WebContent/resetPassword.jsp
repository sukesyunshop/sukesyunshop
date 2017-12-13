<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>パスワードの再設定</title>


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

		<table>
			<s:form action="ConfirmPasswordAction">
				<tr>
					<td>
						<label>ログインID:</label>
					</td>
					<td>
						<input type="text" name="loginId" value="">
					</td>
				</tr>
				<tr>
					<td>
						<label>新しいパスワード:</label>
					</td>
					<td>
						<input type="text" name="loginPassword" value="">
					</td>
					</tr>
				<tr>
					<td>
						<label>再確認用パスワード:</label>
					</td>
					<td>
						<input type="password" name="confirmPassword" value="">
					</td>
				</tr>
						<p><span style="color:#FF0000"><s:property value="userIdMessage" /></span></p>
						<p><span style="color:#FF0000"><s:property value="passwordMessage"/></span></p>
				<s:submit value="登録"/>
			</s:form>
		</table>
<div>
	<span>Login画面に戻る場合は</span><a href="./login.jsp">こちら</a>
</div>
</body>
</html>