<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="">
    <meta name="description" content="Online garden shop">
    <meta name="keywords" content="garden, shop, plants, decorate,
            decoration">


    <!--ios compatibility-->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-title" content="garden Shop">
    <link rel="apple-touch-icon" href="apple-icon-144x144.png">


    <!--Android compatibility-->

    <meta name="mobile-web-app-capable" content="yes">
    <meta name="application-name" content="Garden Shop">
    <link rel="icon" type="image/png" href="android-icon-192x192.png">

    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />


    <!--FONTS-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/front/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <!--THEME CSS-->
    <link href="${pageContext.request.contextPath}/front/css/theme.css" rel="stylesheet" type="text/css" />




    <title>Garden Shop</title>
</head>

<body>
 <!--HEADER START--> <!-- INCLUDE JSP!!! -->
<!--HEADER ENDS--> <!-- INCLUDE JSP!!! -->

<jsp:include page="include-front-header.jsp"/> 

<!--NAVIGATION START--> <!-- INCLUDE JSP!!! -->
<!--NAVIGATION ENDS--> <!-- INCLUDE JSP!!! --> 

<main>

    <!--HOMEPAGE MAIN SLIDER START-->
    <section class="homepage-main-slider-index">
            <ul class="lead-slider-1 list-unstyled owl-carousel owl-loaded owl-drag">
                
                
                
           
            <c:forEach var="slider" items="${sliders}">
            <li class="d-flex" style="background-image: linear-gradient(180deg, rgba(0,0,0,0) 0%, #000000 100%), url('${pageContext.request.contextPath}/slike/${slider.image}')">
                    <div class="container align-self-end">
                        <div class="lead-slider-details">
                            <h4 class="text-white">${slider.title}</h4>
                            <h1 class="text-white text-uppercase py-2 py-md-3 py-lg-4">${slider.description}</h1>
                            <a href="${slider.url}" class="d-inline-block btn btn-warning text-uppercase" target="_blank">${slider.buttonTitle}</a>
                        </div>
                    </div>
                </li>
                
            </c:forEach>    
                
                
              </ul>
        </section>
    <!--HOMEPAGE MAIN SLIDER ENDS-->

    <!--HOMEPAGE MAIN CARDS START-->
    <section class="main-cards py-3 py-lg-4 mb-2 mb-lg-4" style="background-color: #fff;">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-6 mb-2 mb-lg-0">
                    <div class="bg-secondary b-radius">
                        <a href="about-us" class="d-flex justify-content-center align-items-center py-3 py-lg-4">
                            <figure class="mb-0"><img class="d-inline-block" src="${pageContext.request.contextPath}/front/img/index/key.png" alt="" /></figure>
                            <h1 class="text-uppercase mb-0 ml-3">About us</h1>
                        </a>
                    </div>
                </div>
                <div class="col-12 col-md-6 mb-2 mb-lg-0">
                    <div class="bg-secondary b-radius">
                        <a href="shop-list" class="d-flex justify-content-center align-items-center py-3 py-lg-4">
                            <figure class="mb-0"><img class="d-inline-block" src="${pageContext.request.contextPath}/front/img/index/shopping-cart.png" alt="" />
                            </figure>
                            <h1 class="text-uppercase mb-0 ml-3">GARDEN SHOP</h1>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--HOMEPAGE MAIN CARDS ENDS-->


    <!--MOST POPULAR PRODUCTS STARTS-->
    <section class="popular-products mb-2 mb-lg-4" style="background-color: #fff;">
        <div class="container text-center">
            <h3 class="text-uppercase mb-0">MOST POPULAR PRODUCTS</h3>
            <ul class="list-unstyled owl-carousel popular-products-slider pb-3 pb-lg-4">
                
             <c:forEach var="product" items="${products}">  
                
                <li>
                    <article class="popular-products-item mb-2 mb-lg-0">
                        <figure class="mb-3 d-flex justify-content-center align-items-center">
                            <a href="shop-detail/${product.ceoTitle}/${product.id}" class="d-block"><img src="${pageContext.request.contextPath}/slike/${product.image}" alt="" /></a>
                            
                            <c:set scope="page" var="tempSticker" value="${product.randomSticker}"/>
                            <c:if test="${tempSticker!=null}">
                            <p style="background-color: ${tempSticker.color};" class="discount">
                                ${tempSticker.title}
                            </p>
                            </c:if>
                            
                        </figure>
                        <div class="popular-products-details text-center text-lg-left">
                            <h5 class="mb-1"><a href="#" class="text-uppercase">${product.category.name}</a></h5>
                            <p class="text-uppercase mb-2">${product.title}</p>
                            <p class="text-uppercase">${product.price} din</p>
                        </div>
                    </article>
                </li>
       
      		</c:forEach>   
        
       

            </ul>
        </div>
    </section>
    <!--MOST POPULAR PRODUCTS ENDS-->
 <!--HOMEPAGE OUR PRODUCTS START-->
    <section class="our-products mb-5" style="background-color: #fff;">
        <div class="container text-center">
            <h3 class="text-uppercase mb-4 mb-xl-5"><a href="#">OUR PRODUCTS CATEGORY</a></h3>
            <div class="row">
            
            
            <c:forEach var="category" items="${categories}">
                <div class="col-xm-6 col-lg-3 our-products-wrapper">
                    <article class="popular-products-item mb-4 mb-lg-0 d-inline-block">
                        <figure class="mb-3 mb-lg-4 d-flex justify-content-center align-items-center">
                            <a href="shop-list?category=${category.id}" class="d-block"><img class="product-hover"
                                    src="${category.image}" alt="" /></a>
                        </figure>
                        <div class="our-products-details text-left">
                            <h5 class="mb-2 mb-md-3 mb-xl-4"><a href="shop-list?category=${category.id}" class="text-uppercase">${category.name}</a></h5>
                        </div>
                    </article>
                </div>

			</c:forEach>
			
            </div>
        </div>
    </section>
    <!--HOMEPAGE OUR PRODUCTS ENDS-->

</main>

    <!--FOOTER START-->
		<jsp:include page="include-front-footer.jsp"/>
    <!--FOOTER ENDS-->


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="${pageContext.request.contextPath}/front/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/popper.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/front/js/owl.carousel.min.js" type="text/javascript"></script>


<script src="${pageContext.request.contextPath}/front/js/main.js" type="text/javascript"></script>


</body>

</html>