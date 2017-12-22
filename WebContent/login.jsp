<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<link rel="stylesheet" type="text/css" href="./css/template.css">
	<link rel="stylesheet" type="text/css" href="./css/login.css">
	<title>Insert title here</title>
</head>
<body>

<!---------------ヘッダー -------------->
<div id="header">
	<a href="<s:url action="GoHomeAction"/>"><img src="./images/logo.png"></a>

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


<!--ログインIDパスワード-->
	<div id="form">
		<p><s:property value="message" /></p>
			<s:form action="LoginAction" theme="simple">
				<p><span style="color:#FF0000"><s:property value="userIdMessage" /></span></p>
					<div id="login">
						<label>

								<s:if test="#session.userId == ''">
									<input type="text" name="userId" value="" id="loginArea" placeholder="ログインID">
								</s:if>
								<s:else>
									<input type="text" name="userId" id="loginArea" placeholder="ログインID" value="<s:property value="#session.userId" />">
								</s:else>
						</label>
					</div>

				<div id="password">
						<p><span style="color:#FF0000"><s:property value="passwordMessage" /></span></p>
							<label>

								<input type="password" name="password" id="passwordArea" placeholder="パスワード" >
							</label>
				</div>

				<div id="submit">
					<s:submit value="ログイン" id="submitArea" /><br>
					<label>
						<input type="checkbox" name="saveId" value="true">
						ログインIDを保存する
					</label>
				</div>
			</s:form>

			<div id="forgotPass">
				<a href="./resetPassword.jsp">パスワードを忘れた方はこちら</a>
			</div>

	</div>
</body>
</html>