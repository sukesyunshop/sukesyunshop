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

<h1>☆すけしゅんショップ☆ฅ(´-ω-`)ฅ</h1>
<s:property value="#session.loginDTOList.get(0).username"/>さん、ようこそ！
                        <tr>
                        <td>姓：</td>
						<td><s:property value="" escape="false" /></td><br>
						<td>名：</td>
						<td><s:property value="" escape="false" /></td><br>
						<td>ふりがな：</td>
						<td><s:property value="" escape="false" /></td><br>
						<td>性別：</td>
						<td><s:property value="" escape="false" /></td><br>
						<td>メールアドレス：</td>
                        <td><s:property value="" escape="false" /></td><br>
                        </tr>
<a href ="<s;url value ='home.jsp'/>">ホームへ</a>
<a href ="<s:url value ='itemhistory.jsp'/>">購入履歴一覧へ</a>

</body>
</html>