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

<div id="header">
	<h1><span>す</span>け<span>し</span>ゅん<span>S</span>H<span>O</span>P</h1>

<!-- メニューリスト-->
	<ul id="menu">
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
			<a href="CartAction"> <img src="./public/cart.jpg" alt="cart" border="0" class="template"></a>
		</li>
	</ul>

	<!-- 検索バー -->

	<div class="bar">
		<s:form action="SearchAction">
				<input class="input"  type="search" name="searchText" placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">

				<s:submit class="submit" value="検索"/>

		</s:form>
	</div>
</div>


<!--ログインIDパスワード-->
	<div id="form">
		<p><s:property value="message" /></p>
			<s:form action="LoginAction" theme="simple">
				<p><span style="color:#FF0000"><s:property value="userIdMessage" /></span></p>
					<div id="login">
						<label>
							ログインID：
								<s:if test="#session.userId == ''">
									<input type="text" name="userId" value="" id="loginArea">
								</s:if>
								<s:else>
									<input type="text" name="userId" id="loginArea" value="<s:property value="#session.userId" />">
								</s:else>
						</label>
					</div>

<div id="password">
		<p><span style="color:#FF0000"><s:property value="passwordMessage" /></span></p>
			<label>
				パスワード：
				<input type="password" name="password" id="passwordArea" >
			</label>
		</div>

		<div id="submit">
			<s:submit value="ログイン"/>
			<label>
				<input type="checkbox" name="saveId" value="true">
			</label>
		</div>
	</s:form>
		<div id="forgotPass">
			<a href="<s:url action='MoveResetPasswordAction'/>">パスワードを忘れた方はこちら</a>
		</div>
	</div>

</body>
</html>