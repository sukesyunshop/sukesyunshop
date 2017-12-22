<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<link rel="stylesheet" type="text/css" href="./css/error.css">

	<title>Error</title>
	<meta http-equiv="refresh" content="5;URL=<s:url action='GoHomeAction'/>">
</head>
<body>
 <div class="box">
	<p>!外部から侵入されています!<br>データが流失している恐れがあります<br>5秒後に<br>HOME画面に戻ります!!</p>
</div>
</body>
</html>