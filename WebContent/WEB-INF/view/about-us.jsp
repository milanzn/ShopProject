<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/front/">

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

    <div class="container">

        <!--ABOUT US - LEAD ARTICLE START-->
        <section class="services-1-article about-us-lead-article" style="background-color: #fff;">
            <article class="d-flex services-1-lead-article-wrapper justify-content-center b-radius">
                <div class="services-1-article-details align-self-center animation" data-animation="slideDown">
                    <h1><a class="text-white text-uppercase" href="#">about us</a></h1>
                </div>
            </article>
        </section>
        <!--ABOUT US - LEAD ARTICLE ENDS-->


        <!--ABOUT US - MAIN TEXT START-->
        <section class="about-us-main-text">
            <h3 class="text-uppercase">OUR HISTORY</h3>
            <p>
               ${content}
            </p>
        </section>
        <!--ABOUT US - MAIN TEXT ENDS-->


        <!--ABOUT US - BOTTOM ARTICLE START-->
        <section class="d-flex services-1-article-wrapper about-us-bottom-article b-radius"
            style="background-color: #fff">
            <div class="services-1-article-details align-self-end">
                <h1 class="animation" data-animation="slideLeft"><a class="text-white text-uppercase" href="#">Need to
                        take care of your Garden &AMP; Lawn</a></h1>
                <p class="animation" data-animation="slideRight">
                    Nullam ultrices, augue non venenatis bibendum, lacus augue pellentesque quam, nec tempus sem ligula
                    eu mi.
                </p>
                <a href="#" class="d-inline-block btn btn-warning text-uppercase text-white">CONTACT US</a>
            </div>
        </section>
        <!--SERVICES PAGE 1 - ARTICLE ENDS-->

    </div>
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