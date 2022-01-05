<%@ page import="poly.util.CmmUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="poly.dto.MovieDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<MovieDTO> rList = (List<MovieDTO>) request.getAttribute("rList");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>MovieIntroduction</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="/resources/assets/img/favicon.png" rel="icon">
    <link href="/resources/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="/resources/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="/resources/assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="/resources/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="/resources/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="/resources/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="/resources/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="/resources/assets/css/style.css" rel="stylesheet">
</head>
<body>
<header id="header" class="fixed-top d-flex align-items-cente">
    <div class="container-fluid container-xl d-flex align-items-center justify-content-lg-between">

        <h1 class="logo me-auto me-lg-0"><a href="/index.do">MovieIntroduction</a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

        <nav id="navbar" class="navbar order-last order-lg-0">
            <ul>
                <li><a class="nav-link scrollto active" href="#hero">Home</a></li>
                <li><a class="nav-link scrollto" href="#why-us">Introduction</a></li>
                <li><a class="nav-link scrollto" href="#menu">Movie</a></li>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav>

    </div>
</header><!-- End Header -->

<!-- ======= Hero Section ======= -->
<section id="hero" class="d-flex align-items-center">
    <div class="container position-relative text-center text-lg-start" data-aos="zoom-in" data-aos-delay="100">
        <div class="row">
            <div class="col-lg-8">
                <h1>Welcome to <span>MovieIntroduction</span></h1>
                <h2>Check out the movie analysis results!</h2>

                <div class="btns">
                    <a href="#menu" class="btn-menu animated fadeInUp scrollto">Let's go</a>
                </div>
            </div>
            <div class="col-lg-4 d-flex align-items-center justify-content-center position-relative" data-aos="zoom-in" data-aos-delay="200">
                <a href="https://www.youtube.com/watch?v=GlrxcuEDyF8" class="glightbox play-btn"></a>
            </div>

        </div>
    </div>
</section><!-- End Hero -->

<main id="main">



    <!-- ======= Why Us Section ======= -->
    <section id="why-us" class="why-us">
        <div class="container" data-aos="fade-up">

            <div class="section-title">
                <h2>Introduction</h2>
                <p>Let me introduce our service</p>
            </div>

            <div class="row">

                <div class="col-lg-4">
                    <div class="box" data-aos="zoom-in" data-aos-delay="100">
                        <span>01</span>
                        <h4>Crawling</h4>
                        <p>Get the user's comments</p>
                    </div>
                </div>

                <div class="col-lg-4 mt-4 mt-lg-0">
                    <div class="box" data-aos="zoom-in" data-aos-delay="200">
                        <span>02</span>
                        <h4>Analysis</h4>
                        <p>Analysis of comments through opinion mining</p>
                    </div>
                </div>

                <div class="col-lg-4 mt-4 mt-lg-0">
                    <div class="box" data-aos="zoom-in" data-aos-delay="300">
                        <span>03</span>
                        <h4>Show</h4>
                        <p>Classifies and shows the analyzed information</p>
                    </div>
                </div>

            </div>

        </div>
    </section><!-- End Why Us Section -->

    <!-- ======= Menu Section ======= -->
    <section id="menu" class="menu section-bg">
        <div class="container" data-aos="fade-up">

            <div class="section-title">
                <h2>MOVIE</h2>
                <p>Check the actual grade!</p>
            </div>

            <div class="row" data-aos="fade-up" data-aos-delay="100">
                <div class="col-lg-12 d-flex justify-content-center">
                    <ul id="menu-flters">
                        <li data-filter="*" class="filter-active">All</li>
                        <li data-filter=".filter-Action">Action</li>
                        <li data-filter=".filter-SF">SF</li>
                        <li data-filter=".filter-Drama">Drama</li>
                        <li data-filter=".filter-Fantasy">Fantasy</li>
                        <li data-filter=".filter-Thriller">Thriller</li>
                        <li data-filter=".filter-Adventure">Adventure</li>
                    </ul>
                </div>
            </div>

            <div class="row menu-container" data-aos="fade-up" data-aos-delay="200">

                <%
                    for(int i = 0; i < rList.size(); i++) {
                        String class_type = "col-lg-6 menu-item";
                        MovieDTO rDTO = rList.get(i);
                        if (rDTO == null) {
                            rDTO = new MovieDTO();
                        }
                        if (rDTO.getMovie_type().indexOf("액션") != -1){// 장르에 액션이 있다면
                            class_type += " filter-Action";
                        }
                        if (rDTO.getMovie_type().indexOf("모험") != -1){
                            class_type += " filter-Adventure";
                        }
                        if (rDTO.getMovie_type().indexOf("드라마") != -1){
                            class_type += " filter-Drama";
                        }
                        if (rDTO.getMovie_type().indexOf("SF") != -1){
                            class_type += " filter-SF";
                        }
                        if (rDTO.getMovie_type().indexOf("판타지") != -1){
                            class_type += " filter-Fantasy";
                        }

                %>
                <div class="<%=class_type%>">
                    <img src="/resources/assets/movieImg/<%=rDTO.getMovie_code()%>.jpg" class="menu-img" alt="" style="height: 70px;">
                    <div class="menu-content">
                        <a href="https://movie.naver.com/movie/bi/mi/basic.naver?code=<%=rDTO.getMovie_code()%>" data-gall="gallery-item" class="gallery-lightbox"><%=rDTO.getMovie_title()%></a><span>rating : <%=rDTO.getMovie_analysis()%></span>
                    </div>
                    <div class="menu-ingredients">
                        <%=rDTO.getMovie_type()%>
                    </div>
                </div>
                <%}%>
        </div>
        </div>
    </section><!-- End Menu Section -->

</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer">
    <div class="footer-top" style="white : '100%'; height: 300px;">

    </div>
</footer><!-- End Footer -->

<div id="preloader"></div>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="/resources/assets/vendor/aos/aos.js"></script>
<script src="/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/resources/assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="/resources/assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="/resources/assets/vendor/php-email-form/validate.js"></script>
<script src="/resources/assets/vendor/swiper/swiper-bundle.min.js"></script>

<!-- Template Main JS File -->
<script src="/resources/assets/js/main.js"></script>

</body>

</html>