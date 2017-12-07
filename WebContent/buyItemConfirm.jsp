<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>決済確認画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
			<h1>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ</h1>
		</div>
	</div>

	<div id="main">
		<div id="top"></div>
		宛先を選択してください。
		<s:form method="post" action="BuyItemCompleteAction">
			<table>
				<tbody>
					<tr>
						<td><span>宛先を選択してください。</span></td>
						<td><input type="radio" name="" value=""> <span>宛先1</span>
						</td>
						<td></td>
						<td><input type="radio" name="" value=""> <span>宛先2</span></td>
						<td></td>
					</tr>
					<tr>
						<td><span>宛先が未作成の場合は<a
								href='<s:url action="InputDestAction"/>'>新規宛先作成へ</a></span></td>
					</tr>
					<tr>
						<td><input type="submit" value="購入"></td>
					</tr>
				</tbody>
			</table>

			<p>以下の情報で購入しますか？</p>
			<table>
				<tbody>
					<tr>
						<td><label></label></td>

						<td><label></label></td>

						<td><label></label></td>

						<td><label></label></td>

						<td><label></label></td>
					</tr>
				</tbody>
			</table>
		</s:form>

		<br> カート一覧に戻るには<a href='<s:url action="CartAction"/>'>Cartへ</a>

	</div>

</body>
</html>