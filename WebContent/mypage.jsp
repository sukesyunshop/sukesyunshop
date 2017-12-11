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

<h1>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ<br>
	マイページ</h1>
	<s:property value="dto.getFamilyName()" /><s:property value="dto.getFirstName()" />
<s:property value="dto.getUsername"/>さん、ようこそ！<br>
                        <tr>
                        <td>姓：</td>
						<td><td><s:property value="dto.getFamilyName()" /></td></td><br>
						<td>名：</td>
						<td><s:property value="dto.getFirstName()" /></td><br>
						<td>ふりがな：</td>
						<td><s:property value="dto.getFamilyNameKana()"/><s:property value= "dto.getFirstNameKana()" /></td><br>
						<td>性別：</td>
						<td><s:property value="dto.getSex()" /></td><br>
						<td>メールアドレス：</td>
                        <td><s:property value="dto.getEmail()" /></td><br>
                        </tr>

<a href="<s:url action="GoHomeAction" />">HOMEへ</a><br>
<a href="<s:url action="ItemHistoryAction" />">購入履歴へ</a>


</body>
</html>