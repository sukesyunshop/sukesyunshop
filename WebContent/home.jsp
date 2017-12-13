<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/template.css">
	<title>Home</title>
	<!-- <link rel="stylesheet" href="${pageContext.request.contextPath}./css/slider.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script> -->
	<title>Home</title>

<!--
  <script>
    $(document).ready(function(){
      $('.item').bxSlider({
    	  auto: true,
    	  mode: 'fade',
    	  speed: 500,
    	  pause:  5500,
    	  controls: true,


      });
    });
  </script>
 -->

</head>
<body>

<!---------------ヘッダー -------------->
<div id="header">
	<div id="logo">すけしゅんショップ</div>

	<!-- メニューリスト -->
	<ul class="menu">
		<li>
			<s:if test="#session.loginFlag == 'true'">
				<a href="<s:url action='LogoutAction' />">ログアウト</a>
				<a href="<s:url action='GoMyPageAction' />">マイページ</a>
			</s:if>
			<s:else>
				<a href="<s:url action='MoveLoginAction'/>"><img src="./public/login.jpg" alt="login" border="0" class="template"></a>
			</s:else>
		</li>
		<li>
			<a href="CartAction"> <img src="./public/cart.jpg" alt="cart" border="0" class="template"></a>
		</li>
	</ul>

	<!-- 検索バー -->

	<table>

		<s:form action="SearchAction">
			<tr>
				<td><input  type="search" name="searchText" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16"></td>
				<td><s:submit value="検索"/></td>
			</tr>
		</s:form>

	</table>


<!-- カテゴリーリスト -->

		<ul class="category">
			<s:iterator value="cateList">
				<li><a href="<s:url action='SearchAction'><s:param name="categoryId" value="getCategoryId()"/></s:url>"><s:property value="getCategoryName()" /></a></li>
			</s:iterator>
		</ul>
</div>
<!------------ヘッダーここまで ------------>


<!--
<div class="item">
		<div><a href="<s:url action="ProductDetailAction" />"><img src="./public/1.jpg"></a></div>
		<div><a href="<s:url action="ProductDetailAction" />"><img src="./public/2.jpg"></a></div>
		<div><a href="<s:url action="ProductDetailAction" />"><img src="./public/3.jpg"></a></div>
		<div><a href="<s:url action="ProductDetailAction" />"><img src="./public/4.jpg"></a></div>

</div>-->
		<div id="footer">
	</div>
</body>
</html>