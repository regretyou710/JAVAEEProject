<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Product</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="aStar Fashion Template Project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap-4.1.3/bootstrap.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="styles/categories.css">
<link rel="stylesheet" type="text/css"
	href="styles/categories_responsive.css">
</head>
<body>

	<%
		String path1 = (String) request.getContextPath();
		String path2 = path1 + "/page/";
	%>
	<div class="super_container">

		<!-- Header -->

		<header class="header">
			<div
				class="header_content d-flex flex-row align-items-center justify-content-start">

				<!-- Hamburger -->
				<div class="hamburger menu_mm">
					<i class="fa fa-bars menu_mm" aria-hidden="true"></i>
				</div>

				<!-- Logo -->
				<div class="header_logo">
					<a href="<%=path2%>"><div>
							Happy<span>購</span>
						</div></a>
				</div>

				<!-- Navigation -->
				<nav class="header_nav">
					<ul
						class="d-flex flex-row align-items-center justify-content-start">
						<li><a href="<%=path2%>">首頁</a></li>
						<c:choose>
							<c:when test="${empty sessionScope.user or empty sessionScope}">
								<li><a href="<%=path1%>/login/html/register.html">註冊</a></li>
								<li><a href="<%=path1%>/login/html/login.html">登入</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="<%=path1%>/membercenter/index.jsp">會員中心</a></li>
								<li><a href="<%=path1%>/user/logout">登出</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="#">未開發</a></li>
						<!-- Search -->
						<li><div class="">
								<form action="#" class="search_form" id="sidebar_search_form">
									<input type="text" class="search_input" placeholder="快速搜尋"
										required="required" size="15">
									<button class="search_button">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button>
								</form>
							</div></li>
					</ul>
				</nav>

				<!-- Header Extra -->
				<div
					class="header_extra ml-auto d-flex flex-row align-items-center justify-content-start">

					<div class="">
						<div class=""></div>
						<div class=""></div>
						<div class=""></div>
					</div>

					<!-- Currency -->
					<div class="">
						<div class=""></div>
						<div class=""></div>
					</div>

					<!-- Cart -->
					<%
						if (session != null && session.getAttribute("user") != null) {
					%>
					<div
						class="cart d-flex flex-row align-items-center justify-content-start">
						<div class="cart_icon">
							<a href="cart.html"> <img
								src="<%=path1%>/mall/html/images/bag.png" alt="">
								<div class="cart_num">2</div>
							</a>
						</div>
					</div>
					<%
						}
					%>
				</div>

			</div>
		</header>

		<!-- Menu -->

		<div
			class="menu d-flex flex-column align-items-start justify-content-start menu_mm trans_400">
			<div class="menu_close_container">
				<div class="menu_close">
					<div></div>
					<div></div>
				</div>
			</div>
			<div
				class="menu_top d-flex flex-row align-items-center justify-content-start">
				<!-- Language -->
				<div class="">
					<div class=""></div>
					<div class=""></div>
					<div class=""></div>
				</div>
				<div class="info_currencies has_children">
					<div class=""></div>
					<div class=""></div>
				</div>

			</div>
			<div class="menu_search">
				<form action="#" class="header_search_form menu_mm">
					<input type="search" class="search_input menu_mm"
						placeholder="快速搜尋" required="required">
					<button
						class="header_search_button d-flex flex-column align-items-center justify-content-center menu_mm">
						<i class="fa fa-search menu_mm" aria-hidden="true"></i>
					</button>
				</form>
			</div>
			<nav class="menu_nav">
				<ul class="menu_mm">
					<li class="menu_mm"><a href="<%=path2%>">首頁</a></li>
					<c:choose>
						<c:when test="${empty sessionScope.user or empty sessionScope}">
							<li class="menu_mm"><a
								href="<%=path1%>/login/html/register.html">註冊</a></li>
							<li class="menu_mm"><a
								href="<%=path1%>/login/html/login.html">登入</a></li>
						</c:when>
						<c:otherwise>
							<li class="menu_mm"><a
								href="<%=path1%>/membercenter/index.jsp">會員中心</a></li>
							<li class="menu_mm"><a href="<%=path1%>/user/logout">登出</a></li>
						</c:otherwise>
					</c:choose>
					<li class="menu_mm"><a href="#">未開發</a></li>
				</ul>
			</nav>
			<div class="menu_extra">
				<div class="menu_social">
					<ul>
						<li><a href="#"><i class="fa fa-pinterest"
								aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-facebook"
								aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-instagram"
								aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"
								aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</div>
		</div>

		<!-- Sidebar -->

		<div class="sidebar">

			<!-- Info -->
			<div class="info">
				<div
					class="info_content d-flex flex-row align-items-center justify-content-start">

					<!-- Language -->
					<div class="">
						<div class="cart_text"></div>
						<div class=""></div>
						<div class=""></div>
					</div>
					<div class="info_currencies has_children">
						<div class="cart_text"></div>
						<div class=""></div>
					</div>
				</div>
			</div>

			<!-- Logo -->
			<div class="sidebar_logo">
				<a href="<%=path2%>"><div>
						Happy<span>購</span>
					</div></a>
			</div>

			<!-- Sidebar Navigation -->
			<nav class="sidebar_nav">
				<ul>
					<li><a href="<%=path2%>">首頁<i class="fa fa-angle-right"
							aria-hidden="true"></i></a></li>
					<c:choose>
						<c:when test="${empty sessionScope.user or empty sessionScope}">
							<li><a href="<%=path1%>/login/html/register.html">註冊<i
									class="fa fa-angle-right" aria-hidden="true"></i></a></li>
							<li><a href="<%=path1%>/login/html/login.html">登入<i
									class="fa fa-angle-right" aria-hidden="true"></i></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="<%=path1%>/membercenter/index.jsp">會員中心<i
									class="fa fa-angle-right" aria-hidden="true"></i></a></li>
							<li><a href="<%=path1%>/user/logout">登出<i
									class="fa fa-angle-right" aria-hidden="true"></i></a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="#">未開發<i class="fa fa-angle-right"
							aria-hidden="true"></i></a></li>
				</ul>
			</nav>

			<!-- Search -->
			<div class="search">
				<form action="#" class="search_form" id="sidebar_search_form">
					<input type="text" class="search_input" placeholder="快速搜尋"
						required="required">
					<button class="search_button">
						<i class="fa fa-search" aria-hidden="true"></i>
					</button>
				</form>
			</div>

			<!-- Cart -->
			<div
				class="cart d-flex flex-row align-items-center justify-content-start">
				<div class="cart_icon">
					<a href="cart.html"> <img
						src="<%=path1%>/mall/html/images/bag.png" alt="">
						<div class="cart_num">2</div>
					</a>
				</div>
				<div class="cart_text" style="font-size:10px">購物袋</div>
				<div class="cart_price">$39.99 (1)</div>
			</div>
		</div>

		<!-- Home -->
		<%@include file="categories.html"%>
	</div>
	<script src="js/jquery-3.2.1.min.js">
	</script>
<script src="styles/bootstrap-4.1.3/popper.js"></script>
<script src="styles/bootstrap-4.1.3/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="plugins/parallax-js-master/parallax.min.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/Isotope/fitcolumns.js"></script>
<script src="js/categories.js"></script>
</body>
</html>