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
						<td><input type="radio" name="宛先１" value=""> <span>宛先1</span>
						</td>
						<td></td>
						<td><input type="radio" name="宛先２" value=""> <span>宛先2</span></td>
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
					<s:iterator value="cartList">
						<tr>
							<td><label><span>商品名：</span></label></td>

							<td><label><s:property value="getProductNameKana()" /></label></td>
							<td><label><s:property value="getProductName()" /><br></label></td>
							<td><label><s:property value="getImageFilePath()" /></label></td>
							<td><label><s:property value="getImageFileName()" /></label></td>
							<td><label><span>値段</span></label></td>
							<td><label><s:property value="getPrice()" /></label></td>
							<td><label><span>円</span></label></td>
							<td><label><span>発売会社名</span></label></td>
							<td><label><s:property value="getReleaseDate()" /></label></td>
							<td><label><span>発売年月日</span></label></td>
							<td><label><s:property value="getReleaseCompany()" /></label></td>
						</tr>
					</s:iterator>
					<tr>
						<s:iterator  value="destDTOList">
							<td><label><span>宛先情報：</span></label></td>

							<td><label><s:property value="getFamilyName()"/></label></td>

							<td><label><s:property value="getFamilyNameKana()"/></label></td>

							<td><label><s:property value="getFirstName()"/></label></td>

							<td><label><s:property value="getFirstNameKana()"/></label></td>

							<td><label><s:property value="getEmail()"/></label></td>

							<td><label><s:property value="getTelNumber()"/></label></td>

							<td><label><s:property value="UserAddress()"/></label></td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:form>

		<br> カート一覧に戻るには<a href='<s:url action="CartAction"/>'>Cartへ</a>

	</div>

</body>
</html>