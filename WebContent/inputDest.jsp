<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/template.css">
<link rel="stylesheet" type="text/css" href="./css/inputDest.css">
<title>購入情報入力画面</title>
</head>
<body>

	<!---------------ヘッダー -------------->
	<div id="header">
		<a href="<s:url action="GoHomeAction"/>"><img
			src="./images/logo.png"></a>

		<!-- 検索バー -->
		<div class="bar">
			<s:form action="SearchAction">
				<input class="input" type="search" name="searchText"
					placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$"
					title="半角英数　ひらがな　漢字" maxlength="16">
				<s:submit class="submit" value="検索" />
			</s:form>
		</div>

		<!-- メニューリスト-->
		<ul id="menu">
			<s:if test="#session.loginFlag == 'true'">
				<li><a href="<s:url action='LogoutAction' />"><img
						src="./images/logout.png" alt="logout" border="0" class="template"></a></li>
				<li><a href="<s:url action='GoMyPageAction' />"><img
						src="./images/login.png" alt="mypage" border="0" class="template"></a></li>
			</s:if>
			<s:else>
				<li><a href="<s:url action='MoveLoginAction'/>"><img
						src="./images/login.png" alt="login" border="0" class="template"></a></li>
			</s:else>
			<li><a href="CartAction"> <img src="./images/cart.png"
					alt="cart" border="0" class="template"></a></li>
		</ul>

	</div>
	<!------------ヘッダーここまで ------------>

<!-- ここから内容 -->
	<div id="main">
		<div id="top">
			<h3>宛先を入力してください。</h3>
		</div>

		<div class="form">
			<s:form action="ConfirmDestAction">
				<table>
					<tbody>
						<!-- 宛先情報入力フォーム -->

						<tr id="name">
							<th>お名前 :</th>
							<td class="familyName"><input type="text" name="familyName"
								value="" placeholder="姓"></td>
							<td class="firstName"><input type="text" name="firstName"
								value="" placeholder="名"></td>
						</tr>
						<tr id="nameKana">
							<th>ふりがな：</th>
							<td class="familyNameKana"><input type="text"
								name="familyNameKana" value="" placeholder="せい"></td>
							<td class="firstNameKana"><input type="text"
								name="firstNameKana" value="" placeholder="めい"></td>
						</tr>
						<tr id="email">
							<th>メールアドレス：</th>
							<td class="email"><input type="email" name="email" value=""
								placeholder="メールアドレス"></td>
						</tr>

						<tr id="telNumber">
							<th>電話番号：</th>
							<td class="telNumber"><input type="text" name="telNumber"
								value="" placeholder="電話番号"></td>
						</tr>

						<tr id="userAddress">
							<th>住所：</th>
							<td class="userAddess"><input type="text" name="userAddress"
								value="" placeholder="住所"></td>
						</tr>

						<!-- 性別ラジオボタン -->
						<tr id="sex">
							<th>性別：</th>
							<td class="sex"><input type="radio" name="sex" value="0"
								checked="checked"><span>男性</span></td>

							<td class="sex"><input type="radio" name="sex" value="1"><span>女性</span></td>
						</tr>
					</tbody>
				</table>

				<!-- エラーメッセージ群 -->
				<span style="color: #FF0000"><s:property
						value="familyMessage" /></span>
				<span style="color: #FF0000"><s:property value="firstMessage" /></span>
				<span style="color: #FF0000"><s:property
						value="firstKanaMessage" /></span>
				<span style="color: #FF0000"><s:property value="emailMessage" /></span>
				<span style="color: #FF0000"><s:property
						value="telNumberMessage" /></span>
				<span style="color: #FF0000"><s:property
						value="addressMessage" /></span>

				<!-- 購入ボタン -->
				<div id="Button">
					<s:submit class="button" value="確認画面へ" />
				</div>
			</s:form>
		</div>
		<div id="goMyPage">
			MyPageへ戻るには<a href="myPage.jsp">MyPageへ</a>
		</div>
	</div>



</body>
</html>