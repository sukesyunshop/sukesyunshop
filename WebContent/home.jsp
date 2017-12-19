<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/template.css">

	<link rel="stylesheet" type="text/css" href="./css/slider.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<title>Home</title>

  <script>
    $(document).ready(function(){
      $('.pickup').bxSlider({
    	  auto: true,
    	  speed: 500,
    	  pause:  3000,
    	  pager: true,
    	  controls: true,
    	  minSlides: 7,
    	  maxSlides: 7,
    	  slideWidth: 800,
    	  slideMargin: 15,
    	  moveSlides: 1,
    	  startSlide: 0,
    	  autoHover: false,
      });
    });
  </script>
</head>
<body>

<!---------------ヘッダー -------------->
<div id="header">
	<h1><span>す</span>け<span>し</span>ゅん<span>S</span>H<span>O</span>P</h1>
	<!-- メニューリスト-->
	<ul id="menu">
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

<!------------ヘッダーここまで ------------>


	<!-- 検索バー -->
	<div class="bar">
		<s:form action="SearchAction">
				<input class="input"  type="search" name="searchText" placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
				<s:submit class="submit" value="検索"/>
		</s:form>
	</div>
	</div>



<!--------- カテゴリーリスト --------->
		<ul id="category">
			<s:iterator value="cateList">
				<li><a href="<s:url action='SearchAction'><s:param name="categoryId" value="getCategoryId()"/></s:url>"><s:property value="getCategoryName()" /></a></li>
			</s:iterator>
		</ul>


<!--------メインコンテンツ--------->
	<div id="main">


	<div id="pickup-wrap">
		<div id="pickup-wrap-inner">
			<ul class="pickup">
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/1.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/2.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/3.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/4.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/5.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/6.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/7.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/8.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/9.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/10.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/11.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/12.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/13.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/20.jpg"></a></li>
			</ul>
		</div>
	</div>

	<div id="pickup-wrap">
		<div id="pickup-wrap-inner">
			<ul class="pickup">
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/1.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/2.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/3.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/4.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/5.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/6.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/7.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/8.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/9.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/10.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/11.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/12.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/13.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/20.jpg"></a></li>
			</ul>
		</div>
	</div>

	<div id="pickup-wrap">
		<div id="pickup-wrap-inner">
			<ul class="pickup">
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/1.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/2.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/3.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/4.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/5.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/6.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/7.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/8.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/9.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/10.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/11.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/12.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/13.jpg"></a></li>
			<li><a href="<s:url action="ProductDetailAction" />"><img src="./public/20.jpg"></a></li>
			</ul>
		</div>
	</div>




	</div>


	<div id="footer">
	</div>
</body>
</html>