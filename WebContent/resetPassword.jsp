<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>パスワードの再設定</title>


<style type="text/css">

/*=============レイアウト===========*//

</style>
</head>
<body>
		<table>
			<s:form action="ConfirmPasswordAction">
				<tr>
					<td>
						<label>ログインID:</label>
					</td>
					<td>
						<input type="text" name="loginId" value="">
					</td>
				</tr>
				<tr>
					<td>
						<label>新しいパスワード:</label>
					</td>
					<td>
						<input type="text" name="loginPassword" value="">
					</td>
					</tr>
				<tr>
					<td>
						<label>再確認用パスワード:</label>
					</td>
					<td>
						<input type="password" name="confirmPassword" value="">
					</td>
				</tr>
						<p><span style="color:#FF0000"><s:property value="userIdMessage" /></span></p>
						<p><span style="color:#FF0000"><s:property value="passwordMessage"/></span></p>
				<s:submit value="登録"/>
			</s:form>
		</table>
<div>
	<span>Login画面に戻る場合は</span><a href="./login.jsp">こちら</a>
</div>
</body>
</html>