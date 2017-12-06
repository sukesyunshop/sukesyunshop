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

	<p>aa<s:property value="#session.userId"/>zz</p>

	<s:if test="#session.loginFlag == 'true'">
		<a href="<s:url action='LogoutAction' />">ログアウト</a>
	</s:if>
	<s:else>
		<a href="./login.jsp">ログイン</a>
	</s:else>

	<s:form action="MyAction">
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