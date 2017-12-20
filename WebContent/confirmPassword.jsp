<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/confirmPassword.css">
<title>パスワード再設定確認画面</title>

</head>
<body>

	<div id="header">

		<h1>
			<span>す</span>け<span>し</span>ゅん<span>S</span>H<span>O</span>P
		</h1>


		<ul id="menu">
			<li><s:if test="#session.loginFlag == 'true'">
					<a href="<s:url action='LogoutAction' />">ログアウト</a>
					<a href="<s:url action='GoMyPageAction' />">マイページ</a>
				</s:if> <s:else>
					<a href="<s:url action='MoveLoginAction'/>"><img
						src="./public/login.jpg" alt="login" border="0" class="template"></a>
				</s:else></li>
			<li><a href="CartAction"><img src="./public/cart.jpg"
					alt="cart" border="0" class="template"></a></li>
		</ul>

		<div class="bar">
			<s:form action="SearchAction">
				<input class="input" type="search" name="searchText"
					pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字"
					maxlength="16">
				<s:submit class="submit" value="検索" />
			</s:form>
		</div>
	</div>

	<div class="content">
		<h3>登録する内容は以下でよろしいですか。</h3>

		<s:form action="CompletePasswordAction">
			<div class="confirmPassword">
				再設定されるパスワード:
				<s:property value="loginPassword" />
			</div>

			<s:submit class="button" value="完了" />
		</s:form>
		<div id="back">
			<span>前画面に戻る場合は</span><a href="./resetPassword.jsp">こちら</a>
		</div>
	</div>
</body>
</html>