<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
</head>
<body>

	<p><s:property value="message" /></p>

	<s:form action="LoginAction" theme="simple">
		<p><s:property value="userIdMessage" /></p>
		<label>
			ログインID：
			<s:if test="#session.userId == ''">
				<input type="text" name="userId" value="">
			</s:if>
			<s:else>
				<input type="text" name="userId" value="<s:property value="#session.userId" />">
			</s:else>
		</label><br>
		<p><s:property value="passwordMessage" /></p>
		<label>
			パスワード：
			<input type="password" name="password">
		</label>
		<s:submit value="ログイン"/>
		<label>
			<input type="checkbox" name="saveId" value="true">
		</label>
	</s:form>

	<a href="./resetPassword.jsp">パスワードを忘れた方はこちら</a>

</body>
</html>