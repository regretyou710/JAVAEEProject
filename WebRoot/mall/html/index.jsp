<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Happy購</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="../html/styles/bootstrap-4.1.3/bootstrap.css">

<link href="../html/plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="../html/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="../html/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css"
	href="../html/plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css"
	href="../html/styles/main_styles.css">
<link rel="stylesheet" type="text/css"
	href="../html/styles/responsive.css">

<script src="../html/js/jquery-3.2.1.min.js"></script>
<script src="../html/styles/bootstrap-4.1.3/popper.js"></script>
<script src="../html/styles/bootstrap-4.1.3/bootstrap.min.js"></script>
<script src="../html/plugins/greensock/TweenMax.min.js"></script>
<script src="../html/plugins/greensock/TimelineMax.min.js"></script>
<script src="../html/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="../html/plugins/greensock/animation.gsap.min.js"></script>
<script src="../html/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="../html/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="../html/plugins/easing/easing.js"></script>
<script src="../html/plugins/parallax-js-master/parallax.min.js"></script>
<script src="../html/plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="../html/plugins/Isotope/fitcolumns.js"></script>
<script src="../html/js/custom.js"></script>
</head>

<body>

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
				<a href="#"><div>
						Happy<span>購</span>
					</div></a>
			</div>

			<!-- Navigation -->
			<nav class="header_nav">
			<ul class="d-flex flex-row align-items-center justify-content-start">
				<li><a href="index.jsp">首頁</a></li>
				<li><a href="../../login/html/login.html">登入</a></li>
				<li><a href="../../login/html/register.html">註冊</a></li>
				<c:if test="${!empty sessionScope.user}">
					<li><a href="../../membercenter/index.jsp">會員中心</a></li>
				</c:if>
				<li><a href="../../user/logout">登出</a></li>
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
						<a href="cart.html"> <img src="../html/images/bag.png" alt="">
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
				<li class="menu_mm"><a href="index.jsp">首頁</a></li>
				<li class="menu_mm"><a href="../../login/html/login.html">登入</a></li>
				<li class="menu_mm"><a href="../../login/html/register.html">註冊</a></li>
				<c:if test="${!empty sessionScope.user}">
					<li class="menu_mm"><a href="../../membercenter/index.jsp">會員中心</a></li>
				</c:if>
				<li class="menu_mm"><a href="../../user/logout">登出</a></li>
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
				<a href="#"><div>
						Happy<span>購</span>
					</div></a>
			</div>

			<!-- Sidebar Navigation -->
			<nav class="sidebar_nav">
			<ul>
				<li><a href="index.jsp">首頁<i class="fa fa-angle-right"
						aria-hidden="true"></i></a></li>
				<li><a href="../../login/html/login.html">登入<i
						class="fa fa-angle-right" aria-hidden="true"></i></a></li>
				<li><a href="../../login/html/register.html">註冊<i
						class="fa fa-angle-right" aria-hidden="true"></i></a></li>
				<c:if test="${!empty sessionScope.user}">
					<li><a href="../../membercenter/index.jsp">會員中心<i
							class="fa fa-angle-right" aria-hidden="true"></i></a></li>
				</c:if>
				<li><a href="../../user/logout">登出<i
						class="fa fa-angle-right" aria-hidden="true"></i></a></li>
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
					<a href="cart.html"> <img src="../html/images/bag.png" alt="">
						<div class="cart_num">2</div>
					</a>
				</div>
				<div class="cart_text" style="font-size:10px">購物袋</div>
				<div class="cart_price">$39.99 (1)</div>
			</div>
		</div>

		<!-- Home -->

		<div class="home">

			<!-- Home Slider -->
			<div class="home_slider_container">
				<div class="owl-carousel owl-theme home_slider">

					<!-- Slide -->
					<div class="owl-item">
						<div class="background_image"
							style="background-image:url(../html/images/home_slider_1.jpg)"></div>
						<div class="home_content_container">
							<div class="home_content">
								<div
									class="home_discount d-flex flex-row align-items-end justify-content-start">
									<div class="home_discount_num">20</div>
									<div class="home_discount_text">Discount on the</div>
								</div>
								<div class="home_title">New Collection</div>
								<div class="button button_1 home_button trans_200">
									<a href="categories.html">Shop NOW!</a>
								</div>
							</div>
						</div>
					</div>

					<!-- Slide -->
					<div class="owl-item">
						<div class="background_image"
							style="background-image:url(../html/images/home_slider_1.jpg)"></div>
						<div class="home_content_container">
							<div class="home_content">
								<div
									class="home_discount d-flex flex-row align-items-end justify-content-start">
									<div class="home_discount_num">20</div>
									<div class="home_discount_text">Discount on the</div>
								</div>
								<div class="home_title">New Collection</div>
								<div class="button button_1 home_button trans_200">
									<a href="categories.html">Shop NOW!</a>
								</div>
							</div>
						</div>
					</div>

					<!-- Slide -->
					<div class="owl-item">
						<div class="background_image"
							style="background-image:url(../html/images/home_slider_1.jpg)"></div>
						<div class="home_content_container">
							<div class="home_content">
								<div
									class="home_discount d-flex flex-row align-items-end justify-content-start">
									<div class="home_discount_num">20</div>
									<div class="home_discount_text">Discount on the</div>
								</div>
								<div class="home_title">New Collection</div>
								<div class="button button_1 home_button trans_200">
									<a href="categories.html">Shop NOW!</a>
								</div>
							</div>
						</div>
					</div>

				</div>

				<!-- Home Slider Navigation -->
				<div class="home_slider_nav home_slider_prev trans_200">
					<div
						class=" d-flex flex-column align-items-center justify-content-center">
						<img src="../html/images/prev.png" alt="">
					</div>
				</div>
				<div class="home_slider_nav home_slider_next trans_200">
					<div
						class=" d-flex flex-column align-items-center justify-content-center">
						<img src="../html/images/next.png" alt="">
					</div>
				</div>

			</div>
		</div>

		<!-- Boxes -->

		<div class="boxes">
			<div class="section_container">
				<div class="container">
					<div class="row">

						<!-- Box -->
						<div class="col-lg-4 box_col">
							<div class="box">
								<div class="box_image">
									<img src="../html/images/box_1.jpg" alt="">
								</div>
								<div class="box_title trans_200">
									<a href="categories.html">女士系列</a>
								</div>
							</div>
						</div>

						<!-- Box -->
						<div class="col-lg-4 box_col">
							<div class="box">
								<div class="box_image">
									<img src="../html/images/box_2.jpg" alt="">
								</div>
								<div class="box_title trans_200">
									<a href="categories.html">男士系列</a>
								</div>
							</div>
						</div>

						<!-- Box -->
						<div class="col-lg-4 box_col">
							<div class="box">
								<div class="box_image">
									<img src="../html/images/box_3.jpg" alt="">
								</div>
								<div class="box_title trans_200">
									<a href="categories.html">未開發</a>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

		<!-- Categories -->

		<div class="categories">
			<div class="section_container">
				<div class="container">
					<div class="row">
						<div class="col text-center">
							<div class="categories_list_container">
								<ul
									class="categories_list d-flex flex-row align-items-center justify-content-start">
									<li><a href="categories.html">人氣商品</a></li>
									<li><a href="categories.html">新品上市</a></li>
									<li><a href="categories.html">促銷商品</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Products -->

		<div class="products">
			<div class="section_container">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="products_container grid">

								<!-- Product -->
								<div class="product grid-item hot">
									<div class="product_inner">
										<div class="product_image">
											<img src="../html/images/product_1.jpg" alt="">
											<div class="product_tag">hot</div>
										</div>
										<div class="product_content text-center">
											<div class="product_title">
												<a href="product.html">long red shirt</a>
											</div>
											<div class="product_price">$39.90</div>
											<div class="product_button ml-auto mr-auto trans_200">
												<a href="#">add to cart</a>
											</div>
										</div>
									</div>
								</div>

								<!-- Product -->
								<div class="product grid-item">
									<div class="product_inner">
										<div class="product_image">
											<img src="../html/images/product_2.jpg" alt="">
										</div>
										<div class="product_content text-center">
											<div class="product_title">
												<a href="product.html">hype grey shirt</a>
											</div>
											<div class="product_price">$19.50</div>
											<div class="product_button ml-auto mr-auto trans_200">
												<a href="#">add to cart</a>
											</div>
										</div>
									</div>
								</div>

								<!-- Product -->
								<div class="product grid-item sale">
									<div class="product_inner">
										<div class="product_image">
											<img src="../html/images/product_3.jpg" alt="">
											<div class="product_tag">sale</div>
										</div>
										<div class="product_content text-center">
											<div class="product_title">
												<a href="product.html">long sleeve jacket</a>
											</div>
											<div class="product_price">
												$32.20<span>RRP 64.40</span>
											</div>
											<div class="product_button ml-auto mr-auto trans_200">
												<a href="#">add to cart</a>
											</div>
										</div>
									</div>
								</div>

								<!-- Product -->
								<div class="product grid-item">
									<div class="product_inner">
										<div class="product_image">
											<img src="../html/images/product_4.jpg" alt="">
										</div>
										<div class="product_content text-center">
											<div class="product_title">
												<a href="product.html">denim men shirt</a>
											</div>
											<div class="product_price">$59.90</div>
											<div class="product_button ml-auto mr-auto trans_200">
												<a href="#">add to cart</a>
											</div>
										</div>
									</div>
								</div>

								<!-- Product -->
								<div class="product grid-item">
									<div class="product_inner">
										<div class="product_image">
											<img src="../html/images/product_5.jpg" alt="">
										</div>
										<div class="product_content text-center">
											<div class="product_title">
												<a href="product.html">long red shirt</a>
											</div>
											<div class="product_price">$79.90</div>
											<div class="product_button ml-auto mr-auto trans_200">
												<a href="#">add to cart</a>
											</div>
										</div>
									</div>
								</div>

								<!-- Product -->
								<div class="product grid-item new">
									<div class="product_inner">
										<div class="product_image">
											<img src="../html/images/product_6.jpg" alt="">
											<div class="product_tag">new</div>
										</div>
										<div class="product_content text-center">
											<div class="product_title">
												<a href="product.html">hype grey shirt</a>
											</div>
											<div class="product_price">$59.90</div>
											<div class="product_button ml-auto mr-auto trans_200">
												<a href="#">add to cart</a>
											</div>
										</div>
									</div>
								</div>

								<!-- Product -->
								<div class="product grid-item">
									<div class="product_inner">
										<div class="product_image">
											<img src="../html/images/product_7.jpg" alt="">
										</div>
										<div class="product_content text-center">
											<div class="product_title">
												<a href="product.html">long sleeve jacket</a>
											</div>
											<div class="product_price">$15.90</div>
											<div class="product_button ml-auto mr-auto trans_200">
												<a href="#">add to cart</a>
											</div>
										</div>
									</div>
								</div>

								<!-- Product -->
								<div class="product grid-item sale">
									<div class="product_inner">
										<div class="product_image">
											<img src="../html/images/product_8.jpg" alt="">
											<div class="product_tag">sale</div>
										</div>
										<div class="product_content text-center">
											<div class="product_title">
												<a href="product.html">denim men shirt</a>
											</div>
											<div class="product_price">
												$43.99<span>RRP 64.40</span>
											</div>
											<div class="product_button ml-auto mr-auto trans_200">
												<a href="#">add to cart</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
