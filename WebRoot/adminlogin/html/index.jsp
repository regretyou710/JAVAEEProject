<%@page import="tw.com.web.RandomController"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	System.out.println(session.getAttribute("vCode"));
	if (session == null || session.getAttribute("vCode") == null)
		response.sendRedirect("../../valid/createRandom");
%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<!-- custom-theme -->
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="SubLime Signup Form web template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);
	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //custom-theme -->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="//fonts.googleapis.com/css?family=Federo" rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Alegreya+Sans+SC:100,100i,300,400,400i,500,500i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<script type="text/javascript">
	$(document).ready(
		function() {
			//alert('');
			$('#img').on('click', function() {
				$(this).attr('src', 'random?' + new Date.getTime());
			});
			<c:if test="${not empty sessionScope.msg}">
				alert('${sessionScope.msg}');
			</c:if>
		}
	);
</script>
</head>
<body>
	<div class="bg" data-vide-bg="video/laptop">
		<div class="center-container">
			<h1 class="agile-head text-center">後台登入</h1>
			<div class="container">
				<div class="form_w3layouts">
					<form action="../../user/adminLogin" method="post"
						class="w3_agile_login">
						<p>帳號</p>
						<input type="text" name="name" value="admin" />
						<p>密碼</p>
						<input type="password" name="password" value="a" />
						<p>驗證碼</p>
						<input type="text" name="validCode" /> <img alt="請輸入圖片字元"
							src="../../images/vCode.jpg" id="img">
						<p>
							<a href="../../valid/createRandom" style="color:#00D6D6;">看不清楚？換一張</a>
						</p>
						<div class="w3_agile_login">
							<input type="submit" value="登入">
						</div>
					</form>
				</div>
			</div>
			<div class="agileits-w3layouts-copyright text-center">
				<p></p>
			</div>
		</div>
	</div>
	<!-- pop-up-box -->
	<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!--//pop-up-box -->
	<script>
		$(document).ready(function() {
			$('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
				type : 'inline',
				fixedContentPos : false,
				fixedBgPos : true,
				overflowY : 'auto',
				closeBtnInside : true,
				preloader : false,
				midClick : true,
				removalDelay : 300,
				mainClass : 'my-mfp-zoom-in'
			});
		});
	</script>
	<script src="js/jquery.vide.min.js"></script>
</body>
</html>

