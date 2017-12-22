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
<link rel="stylesheet" type="text/css" href="./css/confirmDest.css">
<title>購入情報確認画面</title>
</head>
<body>
	<!---------------ヘッダー -------------->
	<div id="header">
		<a href="<s:url action="GoHomeAction"/>"><img src="./images/logo.png"></a>

		<!-- 検索バー -->
		<div class="bar">
			<s:form action="SearchAction">
					<input class="input"  type="search" name="searchText" placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
					<s:submit class="submit" value="検索"/>
			</s:form>
		</div>

		<!-- メニューリスト-->
		<ul id="menu">
				<s:if test="#session.loginFlag == 'true'">
					<li><a href="<s:url action='LogoutAction' />"><img src="./images/logout.png" alt="logout" border="0" class="template"></a></li>
					<li><a href="<s:url action='GoMyPageAction' />"><img src="./images/login.png" alt="mypage" border="0" class="template"></a></li>
				</s:if>
				<s:else>
					<li><a href="./login.jsp"><img src="./images/login.png" alt="login" border="0" class="template"></a></li>
				</s:else>
			<li>
				<a href="CartAction"> <img src="./images/cart.png" alt="cart" border="0" class="template"></a>
			</li>
		</ul>

	</div>
	<!------------ヘッダーここまで ------------>


	<!------宛先入力確認 ------->
	<div class="content">
		<h2 class="confirm">宛先確認</h2>
		<h3 class="message">以下の宛先を登録してよろしいですか？</h3>
		<table>
			<tbody>
				<tr>
					<th>お名前</th>
					<td><s:property value="familyName" /> <s:property
							value="firstName" />
				</tr>
				<tr>
					<th>ふりがな</th>
					<td><s:property value="familyNameKana" /> <s:property
							value="firstNameKana" />
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><s:property value="email" />
				</tr>
				<tr>
					<th>電話番号</th>
					<td><s:property value="telNumber" />
				</tr>
				<tr>
					<th>住所</th>
					<td><s:property value="userAddress" />
				</tr>
				<tr>
					<th>性別</th>
					<td><s:property value="sexStr" />

			</tbody>
		</table>
		<s:form action="CompleteDestAction">
			<input name="familyName" type="hidden"
				value="<s:property value='familyName' />" />
			<input name="firstName" type="hidden"
				value="<s:property value='firstName' />" />
			<input name="familyNameKana" type="hidden"
				value="<s:property value='familyNameKana' />" />
			<input name="firstNameKana" type="hidden"
				value="<s:property value='firstNameKana' />" />
			<input name="email" type="hidden"
				value="<s:property value='email' />" />
			<input name="telNumber" type="hidden"
				value="<s:property value='telNumber' />" />
			<input name="userAddress" type="hidden"
				value="<s:property value='userAddress' />" />
			<input name="sex" type="hidden" value="<s:property value='sex' />" />
			<div id="Button">
			<s:submit class="button" value= "登録完了"/>
			</div>
		</s:form>
	</div>
</body>
</html>