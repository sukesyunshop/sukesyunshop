<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧画面</title>
</head>
<body>


<div id="main">

			<p>商品一覧</p>
		</div>
		<div>
		<s:iterator value="list">
		<s:form action="CatalogAction" >

				<tr>
					<td>
						<span>商品名</span>
					</td>
					<td>
						<s:property value="getProductNameKana()" /><br>
					</td>
				</tr>
				<tr>
					<td>
						<s:property value="getProductName()"/><br>
					</td>
				</tr>
				<tr>
					<td>
						<span>値段</span>
					</td>
					<td>
						<s:property value="getPrice()" /><span>円</span>
					</td>
				</tr>
				<tr>
					<td>
						<span>購入個数</span>
					</td>
					<td>
						<select name="count">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<s:submit value="購入"/>
					</td>
				</tr>
</s:form>
</s:iterator>
</div>

</body>
</html>