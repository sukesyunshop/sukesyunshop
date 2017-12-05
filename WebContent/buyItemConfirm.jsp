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
		<s:form name="RadioForm" method="post" action="BuyItemCompleteAction">
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
						<td><span><a href='<s:url action="InputDestAction"/>'>宛先を追加する</a></span></td>
						</tr>
				</tbody>
			</table>


		</s:form>

	</div>




</body>
</html>