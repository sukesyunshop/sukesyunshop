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


<!--------- カテゴリーリスト --------->
		<ul id="category">
			<s:iterator value="categoryList">
				<li>
					<a href="<s:url action='SearchAction'><s:param name="categoryId" value="getCategoryId()"/></s:url>"><s:property value="getCategoryName()" /></a>
				</li>
			</s:iterator>
		</ul>

	<h1 class="title">☆マイページฅ(´-ω-`)ฅ☆</h1>
	<h2 class="welcome"><s:property value="dto.getFamilyName()" /><s:property value="dto.getFirstName()" />さん、ようこそ！</h2>

	<ul class="userList">
		<li class="userItem">
			名前：<s:property value="dto.getFamilyName()" />　<s:property value="dto.getFirstName()" />
		</li>
		<li class="userItem">
			ふりがな：<s:property value="dto.getFamilyNameKana()" />　<s:property value="dto.getFirstNameKana()" />
		</li>
		<li class="userItem">性別：
			<s:if test="dto.getSex() == 0">
				男性
			</s:if>
			<s:else>
				女性
			</s:else>
		</li>
		<li class="userItem">メールアドレス：<s:property value="dto.getEmail()" /></li>
	</ul>

	<div class="moveWrapper">
		<a href="<s:url action="GoHomeAction" />" class="moveItem"><input type="submit" value="HOMEへ" id="submitArea"></a>
		<a href="<s:url action="ItemHistoryAction" />" class="moveItem"><input type="submit" value="購入履歴へ" id="submitArea"></a>
	</div>


</body>
</html>