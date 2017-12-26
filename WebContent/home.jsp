<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
	<meta charset="UTF-8">

	<link rel="stylesheet" type="text/css" href="./css/slider.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<link rel="stylesheet" type="text/css" href="./css/template.css">
	<link rel="stylesheet" type="text/css" href="./css/home.css">

	<script type="text/javascript" src="./javascript/omikuji.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
	<title>Home</title>

  <script>
  <!--広告-->
  $(document).ready(function(){
      $('#poster').bxSlider({
    	  auto: true,
    	  speed: 1500,
    	  pause:  5000,
    	  pager: true,
    	  controls: true,
    	  slideWidth: 800,
    	  slideheight:300,
    	  autoHover: true,
    	  mode: 'fade',
      });
    });

  <!--pickup-->
    $(document).ready(function(){
      $('.pickup').bxSlider({
    	  auto: true,
    	  speed: 500,
    	  pause:  3000,
    	  pager: true,
    	  controls: true,
    	  minSlides: 1,
    	  maxSlides: 4,
    	  slideWidth: 200,
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
		<a href="<s:url action="GoHomeAction"/>"><img src="./images/logo.png"></a>

		<!-- 検索バー -->
		<div class="bar">
			<s:form action="SearchAction" theme="simple">
				<s:select class="selectCategory" name="categoryId" list="categoryList" listKey="categoryId" listValue="categoryName" />
				<input class="input" type="search" name="searchText" placeholder="商品名など" pattern="^[a-zA-Z0-9亜-龠あ-んが-ぼぁ-ょゎっー]*$" title="半角英数　ひらがな　漢字" maxlength="16">
				<s:submit class="submit" value="検索" />
			</s:form>
		</div>

		<!-- メニューリスト-->
		<ul id="menu">
			<s:if test="#session.loginFlag == 'true'">
				<li>
					<a href="<s:url action='LogoutAction' />"><img src="./images/logout.png" alt="logout" border="0" class="template"></a>
				</li>
				<li>
					<a href="<s:url action='GoMyPageAction' />"><img src="./images/login.png" alt="mypage" border="0" class="template"></a>
				</li>
			</s:if>
			<s:else>
				<li>
					<a href="./login.jsp"><img src="./images/login.png"alt="login" border="0" class="template"></a>
				</li>
			</s:else>
			<li>
				<a href="CartAction"> <img src="./images/cart.png"alt="cart" border="0" class="template"></a>
			</li>
		</ul>

	</div>
	<!------------ヘッダーここまで ------------>


<!--------- カテゴリーリスト --------->
		<ul id="category">
			<s:iterator value="categoryList">
				<li>
					<a href="<s:url action='SearchAction'><s:param name="categoryId" value="getCategoryId()"/></s:url>"><s:property value="getCategoryName()" /></a>
				</li>
			</s:iterator>
		</ul>


<!--------メインコンテンツ--------->
	<div id="main">
		<div class="mainContainer">

			<!-- slider -->

			<!-- 広告 -->
			<div id="poster-wrap">
				<h2 class="a1">期間限定</h2>
					<div id="poster">
						<div>
							<a href='<s:url action="AdvertizeAction" ><s:param name="sort" value="getSale()" /></s:url>'><img src="./public/sale.jpg"></a>
						</div>
						<div>
							<a href='<s:url action="AdvertizeAction" ><s:param name="sort" value="getAnime()" /></s:url>'><img src="./public/anime.jpg"></a>
						</div>
					</div>
			</div>


			<!-- pickup -->
			<div id="pickup-wrap">
				<h2 class="a2">ピックアップコーナー</h2>
					<div id="pickup-wrap-inner">
						<ul class="pickup">
							<s:iterator value="randomList">
								<li>
									<a href="<s:url action="ProductDetailAction" ><s:param name="productId" value="getProductId()" /></s:url>"><img src="<s:property value="getImageFilePath()"/>"></a>
								</li>
							</s:iterator>
						</ul>
					</div>
			</div>

		<h2 class="a3">☆運だめし☆</h2>
			<img src="./images/start.png" onClick="omikuji();" id="omikuji" class="start">
		</div>
		<div class="sideContainer">
		<h3>新着</h3>
			<ul class="rankingList">
				<s:iterator value="newArriveList">
					<li class="rankingItem">
						<a href="<s:url action="ProductDetailAction" ><s:param name="productId" value="getProductId()" /></s:url>"><img class="itemImage" alt="image" src="<s:property value="getImageFilePath()"/>">
						<ul class="itemInfoList">
								<li class="itemInfo">
									<s:property value="getProductName()"/>
								</li>
								<li class="itemInfo">
									<s:property value="getPrice()"/>円
								</li>
						</ul>
						</a>
					</li>
				</s:iterator>
			</ul>
		</div>

	</div>

	<div id="footer">
	</div>
</body>
</html>