<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ画面</title>
</head>
<body>
<s:property value="#session.loginDTOList.get(0).username"/>さん、ようこそ！

</body>
</html>