<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ画面</title>
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


	<h1>マイページ</h1>
	<s:property value="dto.getFamilyName()" /><s:property value="dto.getFirstName()" />
<s:property value="dto.getUsername"/>さん、ようこそ！<br>
                      <tr>
                        <td>姓：</td>
						<td><s:property value="dto.getFamilyName()" /></td><br>
						<td>名：</td>
						<td><s:property value="dto.getFirstName()" /></td><br>
						<td>ふりがな：</td>
						<td><s:property value="dto.getFamilyNameKana()"/><s:property value= "dto.getFirstNameKana()" /></td><br>
						<td>性別：</td>
						<td><s:property value="dto.getSex()" /></td><br>
						<td>メールアドレス：</td>
                        <td><s:property value="dto.getEmail()" /></td><br>
                      </tr>

<a href="<s:url action="GoHomeAction" />">HOMEへ</a><br>
<a href="<s:url action="ItemHistoryAction" />">購入履歴へ</a>


</body>
</html>