<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入情報入力画面</title>
</head>
<body>

	<div id="header">
		<div id="pr"></div>
	</div>

	<div id="main">
		<div id="top"></div>
		<h3>宛先を入力してください。</h3>
		<s:form action="ConfirmDestAction">
	姓：
	<p>
				<span style="color: #FF0000"><s:property
						value="familyMessage" /></span>
			</p>
			<input type="text" name="familyName" value="">
			<br />
	名：
	<p>
				<span style="color: #FF0000"><s:property value="firstMessage" /></span>
			</p>
			<input type="text" name="firstName" value="">
			<br />
	姓かな：
	<p>
				<span style="color: #FF0000"><s:property
						value="familyKanaMessage" /></span>
			</p>
			<input type="text" name="familyNameKana" value="">
			<br />
	名かな：
	<p>
				<span style="color: #FF0000"><s:property
						value="firstKanaMessage" /></span>
			</p>
			<input type="text" name="firstNameKana" value="">
			<br />
	メールアドレス：
	<p>
				<span style="color: #FF0000"><s:property value="emailMessage" /></span>
			</p>
			<input type="text" name="email" value="">
			<br />
	電話番号：
	<p>
				<span style="color: #FF0000"><s:property
						value="telNumberMessage" /></span>
			</p>
			<input type="text" name="telNumber" value="">
			<br />
	住所：
	<p>
				<span style="color: #FF0000"><s:property
						value="addressMessage" /></span>
			</p>
			<input type="text" name="userAddress" value="">

			<br />
			<s:submit class="button" value="確認画面へ" />
		</s:form>

		MyPageへ戻るには<a href="myPage.jsp">MyPageへ</a>
	</div>



</body>
</html>