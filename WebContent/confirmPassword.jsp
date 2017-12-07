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
<title>パスワード再設定確認画面</title>

<style type="text/css">
/*==============レイアウト=============*/
</style>
</head>
<body>
	<h3>登録する内容は以下でよろしいですか。</h3>

	<s:form action="CompletePasswordAction" >
		<label>再設定されるパスワード:</label>
			<p><s:property value="loginPassword"/></p>
				<s:submit class="button"  value="完了" />
	</s:form>
	<span>前画面に戻る場合は</span><a href='<s:url action="ResetPasswordAction" />'>こちら</a>
</body>
</html>