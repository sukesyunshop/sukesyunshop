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
	<link rel="stylesheet" type="text/css" href="./css/completePassword.css">
	<title>パスワード再設定完了画面</title>

</head>
<body>

	<!---------------ヘッダー -------------->
	<div id="header">
		<a href="<s:url action="GoHomeAction"/>"><img src="./images/logo.png"></a>

		<!-- 検索バー -->
		<div class="bar">
			<s:form action="SearchAction" theme="simple">
				<s:select class="selectCategory" name="categoryId" list="categoryList" listKey="categoryId" listValue="categoryName" />
				<input class="input" type="search" name="searchText" placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
				<s:submit class="submit" value="検索" />
			</s:form>
		</div>

		<!-- メニューリスト-->
		<ul id="menu">
			<s:if test="#session.loginFlag == 'true'">
				<li>
					<a href="<s:url action='LogoutAction' />"><img src="./images/logout.png" alt="logout" border="0" class="template"></a>
				</li>
				<li>
					<a href="<s:url action='GoMyPageAction' />"><img src="./images/login.png" alt="mypage" border="0" class="template"></a>
				</li>
			</s:if>
			<s:else>
				<li>
					<a href="./login.jsp"><img src="./images/login.png"alt="login" border="0" class="template"></a>
				</li>
			</s:else>
			<li>
				<a href="CartAction"> <img src="./images/cart.png"alt="cart" border="0" class="template"></a>
			</li>
		</ul>

	</div>
	<!------------ヘッダーここまで ------------>


	<!-- パスワード変更完了 -->
	<div class="content">
		<h2 class="complete">パスワード変更完了</h2>
		<h3 class="message">おめでとうございます!<br>パスワードの再設定が完了致しました！</h3>
		<div id="back">
			<span>Login画面へ</span><a href="./login.jsp">戻る</a>
		</div>
	</div>
</body>
</html>