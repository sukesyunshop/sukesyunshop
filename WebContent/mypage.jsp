<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/myPage.css">
<title>マイページ画面</title>
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



	<p>☆マイページฅ(´-ω-`)ฅ☆</p><br>
	<p1><s:property value="dto.getFamilyName()" />
	<s:property value="dto.getFirstName()" />
	<s:property value="dto.getUsername" />
	さん、ようこそ！</p1><br>

		<p2>姓：<s:property value="dto.getFamilyName()" /></p2><br>
		<p3>名：<s:property value="dto.getFirstName()" /></p3><br>
		<p4>ふりがな：<s:property value="dto.getFamilyNameKana()" />
			<s:property value="dto.getFirstNameKana()" /></p4><br>
		<p5>性別：<s:property value="dto.getSex()" /></p5><br>
		<p6>メールアドレス：<s:property value="dto.getEmail()" /></p6><br>


	<div id="HOME"><a href="<s:url action="GoHomeAction" />">HOMEへ</a>
	<br>
	<a href="<s:url action="ItemHistoryAction" />">購入履歴へ</a></div>


</body>
</html>