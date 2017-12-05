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

	<s:form action="LoginAction" theme="simple">
		<input type="text" name="userId">
		<input type="password" name="password">
	</s:form>

</body>
</html>