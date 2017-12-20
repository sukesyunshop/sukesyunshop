<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/buyItemConfirm.css">
<title>決済確認画面</title>
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



	<div id="top">決済確認</div>
	<s:form method="post" action="BuyItemCompleteAction">
		<div id="content">

			<span>宛先1</span> <input type="radio" name="" value="1"> <span>宛先2</span>
			<span>宛先が未作成の場合は<a href='<s:url action="InputDestAction"/>'>新規宛先作成へ</a></span>

		</div>

		<div id="pr">
			<p>以下の情報で購入しますか？</p>
		</div>

		<table>
			<tbody>
				<s:iterator value="cartList">
					<tr>
						<td><label><span>商品名：</span></label></td>

						<td><label><s:property value="getProductNameKana()" /></label></td>
						<td><label><s:property value="getProductName()" /><br></label></td>
						<td><label><s:property value="getImageFilePath()" /></label></td>
						<td><label><s:property value="getImageFileName()" /></label></td>
						<td><label><span>値段</span></label></td>
						<td><label><s:property value="getPrice()" /></label></td>
						<td><label><span>円</span></label></td>
						<td><label><span>発売会社名</span></label></td>
						<td><label><s:property value="getReleaseDate()" /></label></td>
						<td><label><span>発売年月日</span></label></td>
						<td><label><s:property value="getReleaseCompany()" /></label></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<br>

		<table>
			<tbody>
				<s:iterator value="destDTOList">
					<tr>
						<td><label><span>宛先情報：</span></label></td>

						<td><label><s:property value="getFamilyName()"
									escape="false" /></label></td>

						<td><label><s:property value="getFamilyNameKana()"
									escape="false" /></label></td>

						<td><label><s:property value="getFirstName()"
									escape="false" /></label></td>

						<td><label><s:property value="getFirstNameKana()"
									escape="false" /></label></td>

						<td><label><s:property value="getEmail()"
									escape="false" /></label></td>

						<td><label><s:property value="getTelNumber()"
									escape="false" /></label></td>

						<td><label><s:property value="getUserAddress()"
									escape="false" /></label></td>
						<td><input type="radio" name="" value="" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<div class="button">
			<p>
				<button class="button2">購入</button>
			</p>
			カート一覧に戻るには<a href='<s:url action="CartAction"/>'>Cartへ</a>
		</div>
	</s:form>
</body>
</html>