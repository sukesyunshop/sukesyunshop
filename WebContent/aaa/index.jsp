<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/slider.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>



  <script>
    $(document).ready(function(){
      $('.band').bxSlider({
    	  auto: true,
    	  mode: 'fade',
    	  speed: 500,
    	  pause:  5500,
    	  controls: true,


      });
    });
  </script>


</head>





<body>

<header>
	<div class="logo">The Come</div>
	<ul>
		<li><a href="./toptags/welcome.jsp">初めての方へ</a></li>
		<li><a href="./toptags/guide.jsp">ご利用ガイド</a></li>
		<li><a href="./toptags/registration.jsp">会員登録</a></li>
		<li><a href="hello.jsp">MyPage</a></li>
		<li><a href="./toptags/support.jsp">お客様サポート</a></li>
	</ul>
</header>








<div class="band">

		<div><img src="./img/img1.jpg"></div>
		<div><img src="./img/img2.jpg"></div>
		<div><img src="./img/img4.jpg"></div>
		<div><img src="./img/img7.jpg"></div>


</div>


<div class="memo"></div>

	<div><a href="nocturnalbloodlast.jsp">NOCTURNAL BLOODLAST</a></div>
	<div><a href=".jsp">DIAURA</a></div>
	<div><a href=".jsp">Lynch.</a></div>
	<div><a href="gazzet.jsp">the GAZZET</a></div>




</body>
</html>



