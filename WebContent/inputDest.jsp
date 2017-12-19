<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<title>購入情報入力画面</title>
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
		<h3>宛先を入力してください。</h3>
		<s:form action="ConfirmDestAction">

	<!-- 宛先情報入力フォーム -->

			<span style="color: #FF0000"><s:property value="familyMessage" /></span>
			姓：<input type="text" name="familyName" value="">
			<br />

			<span style="color: #FF0000"><s:property value="firstMessage" /></span>
			名：<input type="text" name="firstName" value="">
			<br />

			<span style="color: #FF0000"><s:property
					value="familyKanaMessage" /></span>
			姓かな：<input type="text" name="familyNameKana" value="">
			<br />

			<span style="color: #FF0000"><s:property
					value="firstKanaMessage" /></span>
			名かな：<input type="text" name="firstNameKana" value="">
			<br />
			<!-- 性別ラジオボタン -->
			性別：<input type="radio" name="sex" value="0" checked="checked"><span>男性</span>
				<input type="radio" name="sex" value="1" ><span>女性</span>

			<span style="color: #FF0000"><s:property value="emailMessage" /></span>
			メールアドレス：<input type="text" name="email" value="">
			<br />

			<span style="color: #FF0000"><s:property
					value="telNumberMessage" /></span>
			電話番号：<input type="text" name="telNumber" value="">
			<br />

			<span style="color: #FF0000"><s:property
					value="addressMessage" /></span>
			住所：<input type="text" name="userAddress" value="">

			<br />
			<s:submit class="button" value="確認画面へ" />
		</s:form>

		MyPageへ戻るには<a href="myPage.jsp">MyPageへ</a>
	</div>



</body>
</html>