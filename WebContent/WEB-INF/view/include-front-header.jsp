<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--HEADER START-->
<header class="py-1 py-lg-4" id="header" style="background-color:
 #6FB25D;">
    <div class="container">
        <div class="row justify-content-between align-items-center">
            <div class="col-12 col-lg-3">
                <a href="#" class="header-brand">
                    <img src="${pageContext.request.contextPath}/front/img/logo.png" alt="" />
                </a>
            </div>
            <div class="col-12 col-lg-6 header-details text-center text-lg-left">
            
                <div>
                    <a class="d-inline-block mr-lg-4" href="#"><img class="mobile" src="${pageContext.request.contextPath}/front/img/icons/mobile.png"
                            alt="" />${locations[0].phone1}</a>
                    <a class="d-inline-block" href="mailto:gardenshop@gmail.com"><img class="mail"
                            src="${pageContext.request.contextPath}/front/img/icons/mail.png" alt="" />${locations[0].email}</a>
                </div>
                <p><img class="clock" src="${pageContext.request.contextPath}/front/img/icons/clock.png" alt="" />${locations[0].workHour} ${locations[0].closed}</p>
                    
           
                    
            </div>
            <div class="col-12 col-lg-3 d-lg-flex justify-content-end">
                <form class="input-group search" method="GET" action="${pageContext.request.contextPath}/shop-search">
                    <input class="form-control" type="text" placeholder="Search" aria-label="Search" name="text">
                    <div class="input-group-append text-center">
                        <button type="submit" name="search-form" value="search"><span
                                class="fa fa-search"></span></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</header>
<!--HEADER ENDS-->



<!--NAVIGATION START-->
<section class="navigation py-2 p-lg-0" style="background-color:
 #6FB25D;">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-green">
            <a class="navbar-brand" href="#">
                <img src="img/logo.png" alt="" />
            </a>
            <a class="search-mobile ml-auto" href="#">
                <span class="fa fa-search"></span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span></span>
                <span></span>
                <span></span>
            </button>
            <div class="search-toggle">
                <form class="input-group search" method="GET" action="">
                    <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                    <div class="input-group-append text-center">
                        <button type="submit" name="search-form" value="search"><span
                                class="fa fa-search"></span></button>
                    </div>
                </form>
            </div>
            <div class="collapse navbar-collapse mt-2 mt-lg-0" id="main-menu">
                <ul class="navbar-nav mr-auto mr-lg-0 mb-3 mb-lg-0
                 text-center">
                    <li class="nav-item active">
                        <a class="nav-link" href="/ProjectShop/homepage">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ProjectShop/shop-list">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/ProjectShop/location">Location</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="${pageContext.request.contextPath}/about-us">About us</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="${pageContext.request.contextPath}/contact-form">Contact</a>
                    </li>

                </ul>
            </div>
        </nav>
    </div>
</section>
<!--NAVIGATION ENDS-->