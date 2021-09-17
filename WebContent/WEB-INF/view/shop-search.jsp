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

        <!--SHOP 1 STARTS-->
        <section class="shop-1 popular-products mb-2 mb-lg-4" style="background-color: #fff;">
            <div class="container text-center">
                <div class="row">
                    
                    
                    <div class="col-lg-9 popular-products-slider grid-view shop-wrapper">
                        <div class="shop-icons-wrapper d-flex
                            justify-content-between align-items-center
                            align-items-lg-baseline">
                            <a href="#" class="side-nav-button" ><span class="fa
                                    fa-list d-inline-block"></span></a>
                            <h4 class="text-uppercase ml-auto mr-lg-auto
                                ml-lg-0">all products</h4>
                        </div>
                        <div class="row">
                        
                         <c:forEach var="product" items="${products}">
                            <div class="col-xxm-6 col-md-4">
                                <article class="popular-products-item mb-2
                                    mb-lg-0">
                                    <figure class="mb-3 d-flex
                                        justify-content-center
                                        align-items-center">
                                        <a href="shop-detail/${product.ceoTitle}/${product.id}" class="d-block"><img height="200" width="auto" src="${pageContext.request.contextPath}/slike/${product.image}"
                                                alt="" /></a>
                                        
                                        <c:set scope="page" var="tempSticker" value="${product.randomSticker}"/>
                           				 <c:if test="${tempSticker!=null}">
                            					<p style="background-color: ${tempSticker.color};" class="discount">
                               					 ${tempSticker.title}
                            					</p>
                            			 </c:if>
                                        
                                    </figure>
                                    <div class="popular-products-details
                                        text-center text-lg-left">
                                        <h5 class="mb-1"><a href="shop-detail/${product.ceoTitle}/${product.id}" class="text-uppercase">${product.title}</a></h5>
                                        <p class="text-uppercase mb-2">${product.category.name}</p>
                                        <p class="text-uppercase">${product.formattedPrice} din</p>
                                    </div>
                                </article>
                            </div>
                        
                     </c:forEach>
                            
                            
           
                      
                        </div>
                        <!--PAGINATION START-->
                        <div class="pagination-gallery pagination-shop">
                            <ul class="pagination d-flex
                                justify-content-center">
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item active"><a class="page-link" href="#">2</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#">
                                        <span class="fa fa-angle-right"></span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!--PAGINATION ENDS-->
                    </div>
                </div>
            </div>
        </section>
        <!--SHOP 1 ENDS-->


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