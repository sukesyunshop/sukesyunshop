<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>決済確認画面</title>
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


	<div id="main">
		<div id="top"></div>
		宛先を選択してください。
		<s:form method="post" action="BuyItemCompleteAction">
			<table>
				<tbody>
					<tr>
						<td><span>宛先を選択してください。</span></td>
						<td><input type="radio" name="userId"  value="1" checked = "checked"> <span>宛先1</span>
						</td>
						<td></td>
						<td><input type="radio" name="userId" value="2"> <span>宛先2</span></td>
						<td></td>
					</tr>
					<tr>
						<td><span>宛先が未作成の場合は<a
								href='<s:url action="InputDestAction"/>'>新規宛先作成へ</a></span></td>
					</tr>
					<tr>
						<td><input type="submit" value="購入"></td>
					</tr>
				</tbody>
			</table>

			<p>以下の情報で購入しますか？</p>

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
			<table>
				<tbody>
					<tr>
						<td><label><span>宛先情報：</span></label></td>

						<td><label><s:property value="#session.familyName"
									escape="false" /></label></td>

						<td><label><s:property value="#session.familyNameKana"
									escape="false" /></label></td>

						<td><label><s:property value="#session.firstName"
									escape="false" /></label></td>

						<td><label><s:property value="#session.firstNameKana"
									escape="false" /></label></td>

						<td><label><s:property value="#session.email"
									escape="false" /></label></td>

						<td><label><s:property value="#session.telNumber()"
									escape="false" /></label></td>

						<td><label><s:property value="#session.userAddress()"
									escape="false" /></label></td>
					</tr>



				</tbody>
			</table>
		</s:form>

		<br> カート一覧に戻るには<a href='<s:url action="CartAction"/>'>Cartへ</a>

	</div>

</body>
</html>