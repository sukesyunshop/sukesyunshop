<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>パスワード再設定確認画面</title>

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

	<h3>登録する内容は以下でよろしいですか。</h3>

	<s:form action="CompletePasswordAction" >
		<label>再設定されるパスワード:
			<s:property value="loginPassword"/>
		</label>
				<s:submit class="button"  value="完了" />
	</s:form>
	<span>前画面に戻る場合は</span><a href="./resetPassword.jsp">こちら</a>
</body>
</html>