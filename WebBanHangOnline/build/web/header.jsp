
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/jsp" pageEncoding="UTF-8"%>
<div class="header_area">
    <!--header top--> 
    <div class="header_top">
        <div class="row align-items-center">
            <div class="col-lg-6 col-md-6">
                <div class="switcher">
                    <ul>
                        <li class="languages"><a href="#"><img src="assets\img\logo\fontlogo.jpg" alt=""> English <i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown_languages">
                                <li><a href="#"><img src="assets\img\logo\fontlogo.jpg" alt=""> English</a></li>
                                <li><a href="#"><img src="assets\img\logo\fontlogo2.jpg" alt=""> French </a></li>
                            </ul>   
                        </li> 
                        <li class="currency"><a href="#"> Currency : $ <i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown_currency">
                                <li><a href="#"> Dollar (USD)</a></li>
                                <li><a href="#"> Euro (EUR)  </a></li>
                            </ul> 
                        </li> 
                    </ul>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="header_links">
                    <ul>
                        <li><a href="contact.jsp" title="Contact">Contact</a></li>
                            <c:if test="${sessionScope.acc != null}">
                            <li><a href="wishlist.jsp" title="wishlist">My wishlist</a></li>
                            <li><a href="myaccount.jsp" title="My account">My account</a></li>
                            <li><a href="cart.jsp" title="My cart">My cart</a></li>
                            </c:if>
                            <c:if test="${sessionScope.acc == null}">
                            <li><a href="login.jsp" title="Login">Login</a></li>
                            </c:if>
                            <c:if test="${sessionScope.acc != null}">
                            <li><a  href ="logout" title="Login">Logout</a></li>
                            </c:if>
                    </ul>
                </div>   
            </div>
        </div> 
    </div> 
    <!--header top end-->

    <!--header middel--> 
    <div class="header_middel">
        <div class="row align-items-center">
            <!--logo start-->
            <div class="col-lg-3 col-md-3">
                <div class="logo">
                    <a href="index"><img src="assets\img\logo\logo.jpg.png" alt=""></a>
                </div>
            </div>
            <!--logo end-->
            <div class="col-lg-9 col-md-9">
                <div class="header_right_info">
                    <div class="search_bar">
                        <form action="search">
                            <input name="infor" placeholder="Search..." type="text">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                    <div class="shopping_cart">
                        <a href="#"><i class="fa fa-shopping-cart"></i> ${sessionScope.minicartsoluong} sản phẩm - ${sessionScope.minicarttongtien}đ <i class="fa fa-angle-down"></i></a>
                        <!--mini cart-->
                        <div class="mini_cart">
                            <c:forEach var="sp" items="${sessionScope.gioHang}">
                                <div class="cart_item">
                                    <div class="cart_img">
                                        <a href="#"><img src="${sp.linkAnh}" alt=""></a>
                                    </div>
                                    <div class="cart_info">
                                        <a href="#">${sp.tenSP}</a>
                                        <span class="cart_price">${sp.donGia}</span>
                                        <span class="quantity">Số lượng: ${sp.soLuong}</span>
                                    </div>
                                    <div class="cart_remove">
                                        <a title="Remove this item" href="removeSpcontrol?idrm=${sp.maSP}"><i class="fa fa-times-circle"></i></a>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="shipping_price">
                                <span> Phí ship </span>
                                <span>  0đ  </span>
                            </div>    
                            <div class="total_price">
                                <span> total </span>
                                <span class="prices">
                                    ${requestScope.minicarttongtien}
                                </span>
                            </div>
                            <div class="cart_button">
                                <a href="checkout.jsp"> Check out</a>
                            </div>
                        </div>
                    </div> 
                </div> 
            </div>
        </div>
        <!--mini cart end-->
    </div>

</div>
</div>
</div>
</div>     
<!--header middel end-->      
<div class="header_bottom">
    <div class="row">
        <div class="col-12">
            <div class="main_menu_inner">
                <div class="main_menu d-none d-lg-block">
                    <nav>
                        <ul>
                            <li class="active"><a href="index.jsp">Home</a>
                            </li>
                            <li><a href="shop">shop</a>
                                <div class="mega_menu jewelry">
                                    <div class="mega_items jewelry">
                                        <ul>
                                            <li><a href="shoplist">shop list</a></li>
                                            <li><a href="pageControl">shop Full Width Grid</a></li>
                                            <li><a href="shop-fullwidth-list.jsp">shop Full Width list</a></li>
                                            <li><a href="shop-sidebar.jsp">shop Right Sidebar</a></li>
                                            <li><a href="shop-sidebar-list.jsp">shop list Right Sidebar</a></li>
                                            <li><a href="single-product.jsp">Product Details</a></li>
                                            <li><a href="single-product-sidebar.jsp">Product sidebar</a></li>
                                            <li><a href="single-product-video.jsp">Product Details video</a></li>
                                            <li><a href="single-product-gallery.jsp">Product Details Gallery</a></li>
                                        </ul>
                                    </div>
                                </div>  
                            </li>
                            <li><a href="#">women</a>
                                <div class="mega_menu">
                                    <div class="mega_top fix">
                                        <div class="mega_items">
                                            <h3><a href="#">Accessories</a></h3>
                                            <ul>
                                                <li><a href="#">Cocktai</a></li>
                                                <li><a href="#">day</a></li>
                                                <li><a href="#">Evening</a></li>
                                                <li><a href="#">Sundresses</a></li>
                                                <li><a href="#">Belts</a></li>
                                                <li><a href="#">Sweets</a></li>
                                            </ul>
                                        </div>
                                        <div class="mega_items">
                                            <h3><a href="#">HandBags</a></h3>
                                            <ul>
                                                <li><a href="#">Accessories</a></li>
                                                <li><a href="#">Hats and Gloves</a></li>
                                                <li><a href="#">Lifestyle</a></li>
                                                <li><a href="#">Bras</a></li>
                                                <li><a href="#">Scarves</a></li>
                                                <li><a href="#">Small Leathers</a></li>
                                            </ul>
                                        </div>
                                        <div class="mega_items">
                                            <h3><a href="#">Tops</a></h3>
                                            <ul>
                                                <li><a href="#">Evening</a></li>
                                                <li><a href="#">Long Sleeved</a></li>
                                                <li><a href="#">Shrot Sleeved</a></li>
                                                <li><a href="#">Tanks and Camis</a></li>
                                                <li><a href="#">Sleeveless</a></li>
                                                <li><a href="#">Sleeveless</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="mega_bottom fix">
                                        <div class="mega_thumb">
                                            <a href="#"><img src="assets\img\banner\banner1.jpg" alt=""></a>
                                        </div>
                                        <div class="mega_thumb">
                                            <a href="#"><img src="assets\img\banner\banner2.jpg" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li><a href="#">men</a>
                                <div class="mega_menu">
                                    <div class="mega_top fix">
                                        <div class="mega_items">
                                            <h3><a href="#">Rings</a></h3>
                                            <ul>
                                                <li><a href="#">Platinum Rings</a></li>
                                                <li><a href="#">Gold Ring</a></li>
                                                <li><a href="#">Silver Ring</a></li>
                                                <li><a href="#">Tungsten Ring</a></li>
                                                <li><a href="#">Sweets</a></li>
                                            </ul>
                                        </div>
                                        <div class="mega_items">
                                            <h3><a href="#">Bands</a></h3>
                                            <ul>
                                                <li><a href="#">Platinum Bands</a></li>
                                                <li><a href="#">Gold Bands</a></li>
                                                <li><a href="#">Silver Bands</a></li>
                                                <li><a href="#">Silver Bands</a></li>
                                                <li><a href="#">Sweets</a></li>
                                            </ul>
                                        </div>
                                        <div class="mega_items">
                                            <a href="#"><img src="assets\img\banner\banner3.jpg" alt=""></a>
                                        </div>
                                    </div>

                                </div>
                            </li>


                            <li><a href="blog.jsp">blog</a>
                            </li>
                            <li><a href="contact.jsp">contact us</a></li>

                        </ul>
                    </nav>
                </div>
                <div class="mobile-menu d-lg-none">
                    <nav>
                        <ul>
                            <li><a href="index.jsp">Home</a>
                                <div>
                                    <div>
                                        <ul>
                                            <li><a href="index.jsp">Home 1</a></li>
                                            <li><a href="index-2.jsp">Home 2</a></li>
                                        </ul>
                                    </div>
                                </div> 
                            </li>
                            <li><a href="shop.jsp">shop</a>
                                <div>
                                    <div>
                                        <ul>
                                            <li><a href="shop-list.jsp">shop list</a></li>
                                            <li><a href="shop-fullwidth.jsp">shop Full Width Grid</a></li>
                                            <li><a href="shop-fullwidth-list.jsp">shop Full Width list</a></li>
                                            <li><a href="shop-sidebar.jsp">shop Right Sidebar</a></li>
                                            <li><a href="shop-sidebar-list.jsp">shop list Right Sidebar</a></li>
                                            <li><a href="single-product.jsp">Product Details</a></li>
                                            <li><a href="single-product-sidebar.jsp">Product sidebar</a></li>
                                            <li><a href="single-product-video.jsp">Product Details video</a></li>
                                            <li><a href="single-product-gallery.jsp">Product Details Gallery</a></li>
                                        </ul>
                                    </div>
                                </div>  
                            </li>
                            <li><a href="#">women</a>
                                <div>
                                    <div>
                                        <div>
                                            <h3><a href="#">Accessories</a></h3>
                                            <ul>
                                                <li><a href="#">Cocktai</a></li>
                                                <li><a href="#">day</a></li>
                                                <li><a href="#">Evening</a></li>
                                                <li><a href="#">Sundresses</a></li>
                                                <li><a href="#">Belts</a></li>
                                                <li><a href="#">Sweets</a></li>
                                            </ul>
                                        </div>
                                        <div>
                                            <h3><a href="#">HandBags</a></h3>
                                            <ul>
                                                <li><a href="#">Accessories</a></li>
                                                <li><a href="#">Hats and Gloves</a></li>
                                                <li><a href="#">Lifestyle</a></li>
                                                <li><a href="#">Bras</a></li>
                                                <li><a href="#">Scarves</a></li>
                                                <li><a href="#">Small Leathers</a></li>
                                            </ul>
                                        </div>
                                        <div>
                                            <h3><a href="#">Tops</a></h3>
                                            <ul>
                                                <li><a href="#">Evening</a></li>
                                                <li><a href="#">Long Sleeved</a></li>
                                                <li><a href="#">Shrot Sleeved</a></li>
                                                <li><a href="#">Tanks and Camis</a></li>
                                                <li><a href="#">Sleeveless</a></li>
                                                <li><a href="#">Sleeveless</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div>
                                        <div>
                                            <a href="#"><img src="assets\img\banner\banner1.jpg" alt=""></a>
                                        </div>
                                        <div>
                                            <a href="#"><img src="assets\img\banner\banner2.jpg" alt=""></a>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li><a href="#">men</a>
                                <div>
                                    <div>
                                        <div>
                                            <h3><a href="#">Rings</a></h3>
                                            <ul>
                                                <li><a href="#">Platinum Rings</a></li>
                                                <li><a href="#">Gold Ring</a></li>
                                                <li><a href="#">Silver Ring</a></li>
                                                <li><a href="#">Tungsten Ring</a></li>
                                                <li><a href="#">Sweets</a></li>
                                            </ul>
                                        </div>
                                        <div>
                                            <h3><a href="#">Bands</a></h3>
                                            <ul>
                                                <li><a href="#">Platinum Bands</a></li>
                                                <li><a href="#">Gold Bands</a></li>
                                                <li><a href="#">Silver Bands</a></li>
                                                <li><a href="#">Silver Bands</a></li>
                                                <li><a href="#">Sweets</a></li>
                                            </ul>
                                        </div>
                                        <div>
                                            <a href="#"><img src="assets\img\banner\banner3.jpg" alt=""></a>
                                        </div>
                                    </div>

                                </div>
                            </li>
                            <li><a href="#">pages</a>
                                <div>
                                    <div>
                                        <div>
                                            <h3><a href="#">Column1</a></h3>
                                            <ul>
                                                <li><a href="portfolio.jsp">Portfolio</a></li>
                                                <li><a href="portfolio-details.jsp">single portfolio </a></li>
                                                <li><a href="about.jsp">About Us </a></li>
                                                <li><a href="about-2.jsp">About Us 2</a></li>
                                                <li><a href="services.jsp">Service </a></li>
                                                <li><a href="my-account.jsp">my account </a></li>
                                            </ul>
                                        </div>
                                        <div>
                                            <h3><a href="#">Column2</a></h3>
                                            <ul>
                                                <li><a href="blog.jsp">Blog </a></li>
                                                <li><a href="blog-details.jsp">Blog  Details </a></li>
                                                <li><a href="blog-fullwidth.jsp">Blog FullWidth</a></li>
                                                <li><a href="blog-sidebar.jsp">Blog  Sidebar</a></li>
                                                <li><a href="faq.jsp">Frequently Questions</a></li>
                                                <li><a href="404.jsp">404</a></li>
                                            </ul>
                                        </div>
                                        <div>
                                            <h3><a href="#">Column3</a></h3>
                                            <ul>
                                                <li><a href="contact.jsp">Contact</a></li>
                                                <li><a href="cart.jsp">cart</a></li>
                                                <li><a href="checkout.jsp">Checkout  </a></li>
                                                <li><a href="wishlist.jsp">Wishlist</a></li>
                                                <li><a href="login.jsp">Login</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </li>

                            <li><a href="blog.jsp">blog</a>
                                <div>
                                    <div>
                                        <ul>
                                            <li><a href="blog-details.jsp">blog details</a></li>
                                            <li><a href="blog-fullwidth.jsp">blog fullwidth</a></li>
                                            <li><a href="blog-sidebar.jsp">blog sidebar</a></li>
                                        </ul>
                                    </div>
                                </div>  
                            </li>
                            <li><a href="contract.jsp">contact us</a></li>

                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
</div>