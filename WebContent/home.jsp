<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
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
			<a href="<s:url action='MoveLoginAction'/>"><img src="./public/login.jpg"></a>
		</s:else>
	</li>
	<li>
		<a href="CartAction"><img src="./public/cart.jpg"></a>
	</li>
</ul>




	<ul>
		<s:iterator value="cateList">
			<li><a href="<s:url action='SearchAction'><s:param name="categoryId" value="getCategoryId()"/></s:url>"><s:property value="getCategoryName()" /></a></li>
		</s:iterator>
	</ul>

</div>



	<s:form action="SearchAction">
	<input type="search" name="searchText" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
	<s:submit value="検索"/>
	</s:form>





</body>
</html>