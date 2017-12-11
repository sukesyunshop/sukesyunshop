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
	<input type="text" name="familyName" value="">
			<br />
	名：
	<input type="text" name="firstName" value="">
			<br />
	姓かな：
	<input type="text" name="familyNameKana" value="">
			<br />
	名かな：
	<input type="text" name="firstNameKana" value="">
			<br />
	メールアドレス：
	<input type="text" name="email" value="">
			<br />
	電話番号：
	<input type="text" name="telNumber" value="">
			<br />
	住所：
	<input type="text" name="userAddress" value="">

			<br />
			<s:submit class ="button"  value="確認画面へ"/>
		</s:form>

		MyPageへ戻るには<a href="myPage.jsp">MyPageへ</a>
	</div>



</body>
</html>