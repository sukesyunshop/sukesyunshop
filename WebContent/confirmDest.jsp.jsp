<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入情報確認画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
			<h1>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ</h1>
		</div>
	</div>

	<div id="main">
		<div id="top"></div>
		以下の情報を登録してよろしいですか？
		<s:form action="CompleteDestAction">
			<table>
				<tbody>
					<tr>
						<td><label>姓：</label></td>
						<td><s:property value="" escape="false" /></td>
						<td><label>名：</label></td>
						<td><s:property value="" escape="false" /></td>
						<td><label>姓かな：</label></td>
						<td><s:property value="" escape="false" /></td>
						<td><label>名かな：</label></td>
						<td><s:property value="" escape="false" /></td>
						<td><label>メールアドレス：</label></td>
						<td><s:property value="" escape="false" /></td>
						<td><label>電話番号：</label></td>
						<td><s:property value="" escape="false" /></td>
						<td><label>住所：</label></td>
						<td><s:property value="" escape="false" /></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><input type="submit" value="完了"></td>
					</tr>
				</tbody>
			</table>
		</s:form>
</body>
</html>