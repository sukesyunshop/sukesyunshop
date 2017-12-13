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

	<s:form action="SearchAction">
	<input type="search" name="searchText" value="<s:property value="searchText"/>" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
	<s:submit value="検索"/>
	</s:form>

	<ul>
		<s:iterator value="cateList">
			<li><a href="<s:url action='SearchAction'><s:param name="categoryId" value="getCategoryId()"/></s:url>"><s:property value="getCategoryName()" /></a></li>
		</s:iterator>
	</ul>


<p><s:property value="emptyMessage"/></p>
<ul>
	<s:iterator value="list">
		<li>
				<span>カテゴリー</span>
					<s:property value="getCategoryId()" /><br>
					<img src="<s:property value="getImageFilePath()" />">
				<span>商品名</span>
					<s:property value="getProductNameKana()" /><br>
					<s:property value="getProductName()"/>
				<span>値段</span>
					<s:property value="getPrice()" />
					<span>円</span>
				<a href="<s:url action="ProductDetailAction"><s:param name="productId" value="getProductId()"/></s:url>">商品詳細</a>
		</li>
	</s:iterator>
</ul>

<ul>
	<s:iterator begin="1" end="listSize" status="i">
		<li><a href="<s:url action="SearchAction"><s:param name='page' value="#i.count" /></s:url>"><s:property value="#i.count" /></a></li>
	</s:iterator>
</ul>

</body>
</html>