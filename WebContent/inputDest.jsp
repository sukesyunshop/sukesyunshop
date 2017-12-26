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
		<a href="<s:url action="GoHomeAction"/>"><img src="./images/logo.png"></a>

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

	<!-- ここから内容 -->
	<div id="main">
		<div id="top">
			<h3>宛先を入力してください。</h3>
		</div>

		<div class="form">
			<s:form action="ConfirmDestAction">
				<div class="InputDestination">
					<!-- 宛先情報入力フォーム -->
					<!-- 名前 -->
					<div class="name">
						お名前 : <span style="color: #FF0000"><s:property
								value="familyMessage" /></span> <span style="color: #FF0000"><s:property
								value="firstMessage" /></span><input type="text" name="familyName"
							value='<s:property value="getFamilyName()"/>' placeholder="姓">
						<input type="text" name="firstName"
							value='<s:property value="getFirstName()"/>' placeholder="名">
					</div>


					<!-- かな -->
					<div class="nameKana">
						ふりがな： <span style="color: #FF0000"><s:property
								value="familyKanaMessage" /></span><span style="color: #FF0000"><s:property
								value="firstKanaMessage" /></span> <input type="text"
							name="familyNameKana"
							value='<s:property value="getFamilyNameKana()"/>'
							placeholder="せい"> <input type="text" name="firstNameKana"
							value='<s:property value="getFirstNameKana()"/>' placeholder="めい">
					</div>

					<!-- メールアドレス -->
					<div class="email">
						メールアドレス： <span style="color: #FF0000"><s:property
								value="emailMessage" /></span> <input type="email" name="email"
							value='<s:property value="getEmail()"/>' placeholder="メールアドレス">
					</div>

					<!-- 電話番号 -->
					<div class="telNumber">
						電話番号： <span style="color: #FF0000"><s:property
								value="telNumberMessage" /></span><input type="text" name="telNumber"
							value='<s:property value="getTelNumber()"/>' placeholder="電話番号">
					</div>

					<!-- 住所 -->
					<div class="userAddress">
						住所： <span style="color: #FF0000"><s:property
								value="addressMessage" /></span><input type="text" name="userAddress"
							value='<s:property value="getUserAddess()"/>' placeholder="住所">
					</div>

					<!-- 性別ラジオボタン -->
					<div class="sex">
						性別： <input type="radio" name="sex" value="0" checked="checked">
						<span>男性</span> <input type="radio" name="sex" value="1">
						<span>女性</span>
					</div>

					<!-- 購入ボタン -->
					<div id="Button">
						<s:submit class="button" value="確認画面へ" />
					</div>
				</div>
			</s:form>

		</div>
		<div id="goMyPage">
			MyPageへ戻るには<a href="<s:url action="GoMyPageAction"/>">MyPageへ</a>
		</div>
	</div>

</body>
</html>