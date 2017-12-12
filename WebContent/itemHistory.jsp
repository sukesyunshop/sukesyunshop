<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>

	<title>購入履歴一覧画面</title>
</head>
<body>
<p>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ<br>
     購入履歴一覧</p>
			<s:form>
				<tr>
					<td>商品名:</td>
					<td><s:property value="session.productName" /></td>
				</tr>

				<tr>
					<td>値段:</td>
					<td><s:property value="session.Price" /></td>
				</tr>
				<tr>
					<td>発売会社名:</td>
					<td><s:property value="session.companyName" /></td>
				</tr>
				<tr>
					<td>発売年月日:</td>
					<td><s:property value="session.releaseDate" /></td>
				</tr>
				<tr>
					<td>
						<br>
					</td>
				</tr>

				<a href=img src=""></a>



				<tr>
					<td><input type="button" value="ホームへ戻る" onclick="submitAction('GoHomeAction')" /></td>
				</tr>
				<tr>
					<td><input type="button" value="購入履歴削除" onclick="submitAction('ItemHistoryAction')" /></td>
				</tr>
			</s:form>
</body>
</html>