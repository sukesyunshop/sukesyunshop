<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>購入履歴一覧画面</title>
</head>
<body>
	<p>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ<br>
	購入履歴一覧</p>
	<ul>
		<s:iterator value="list">
			<li>
				商品名:<s:property value="getProductName()"/>
				値段:<s:property value="getPrice()"/>
				発売会社名:<s:property value="getCompanyName()"/>
				発売年月日:<s:property value="getReleaseDate()"/>
			</li>
		</s:iterator>
	</ul>

</body>
</html>