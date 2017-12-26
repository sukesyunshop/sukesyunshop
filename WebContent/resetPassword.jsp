<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" type="text/css" href="./css/template.css">
	<link rel="stylesheet" type="text/css" href="./css/resetPassword.css">
	<title>パスワードの再設定</title>


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

	<div id="form">
			<s:form action="ConfirmPasswordAction" theme="simple">
					<input class="passwordInput" type="text" name="loginId" value="" placeholder="ログインID">
					<input class="passwordInput" type="text" name="loginPassword" value="" placeholder="新しいパスワード">
					<input class="passwordInput" type="password" name="confirmPassword" value="" placeholder="確認用パスワード">
					<p><span style="color:#FF0000"><s:property value="userIdMessage" /></span></p>
					<p><span style="color:#FF0000"><s:property value="passwordMessage"/></span></p>
					<s:submit value="登録" id="submitArea"/>
			</s:form>

		<div id="goHome">
			<span>Login画面に戻る場合は</span><a href="./login.jsp">こちら</a>
		</div>

	</div>
</body>
</html>