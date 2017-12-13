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
	<h1>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ</h1>

	<s:form action="SearchAction">
	<input type="search" name="searchText" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
	<s:submit value="検索"/>
	</s:form>

	<ul>
		<s:iterator value="cateList">
			<li><a href="<s:url action='SearchAction'><s:param name="categoryId" value="getCategoryId()"/></s:url>"><s:property value="getCategoryName()" /></a></li>
		</s:iterator>
	</ul>


	<p>aa<s:property value="#session.userId"/>zz</p>

	<s:if test="#session.loginFlag == 'true'">
		<a href="<s:url action='LogoutAction' />">ログアウト</a>
	</s:if>
	<s:else>
		<a href="<s:url action='MoveLoginAction'/>">ログイン</a>
	</s:else>

	<s:form action="GoMyPageAction">
	<s:submit value="マイページ"/>
	</s:form>

	<s:form action="CartAction">
	<s:submit value="カート画面"/>
	</s:form>

	<s:form action="CatalogAction">
	<s:submit value="商品一覧画面"/>
	</s:form>

</body>
</html>