<%-- 
    Document   : category
    Created on : Jun 1, 2024, 12:34:52 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--End Navbar mobile -->
<!-- Navbar List (Hang ngang khi hover vao dropdown xuat hien) -->
<!-- 1 category o hang navbar list (Neu for each cai nay thi 1 day hang ngang se xuat hien)-->
<c:forEach items="${requestScope.data}" var="category" varStatus="status" >
    <li class="header__dropdown-item hideOnMobile" onmouseover="GetId(${status.index}); GetIdForCollection(${status.index})">
        <input type="hidden" id="category_${status.index}" value="${category.product_category_id}">
        ${category.product_category_name} 
        <div class="header__dropdown--info">
            <div class="header__downdown--category">
                <div class="dropdown-title">
                    <h4 class="dropdown-text">BY CATAGORY</h4>
                    |&nbsp;<span class="text-underline"
                                 ><a href="#" class="black-text-no-underline"
                        >View all</a
                        ></span
                    >
                </div>
                <div class="dropdown-showbox">
                    <ul class="card-list"  id="category_detail_${status.index}">
                        <!-- 1 Cai card nho trong dropdown gom img va ten sp (Foreach cai nay se in ra nhu web hoa luc vua chay chua for each) -->
                        <li class="card-info">
                            <a href="#" class="card-link">
                                <!-- <img
                                  src="./assets/images/logongan.png"
                                  alt=""
                                  class="card-image"
                                /> -->
                                <span class="card-name black-text-no-underline"
                                      >Category 1</span
                                >
                            </a>
                        </li>

                        <!--Ket thuc 1 Cai card nho trong dropdown gom img va ten sp -->
                    </ul>
                </div>
            </div>
            <div class="header__downdown--collection">
                <div class="dropdown-title">
                    <h4 class="dropdown-text">BY COLLECTION</h4>
                    |&nbsp;<span class="text-underline"
                                 ><a href="#" class="black-text-no-underline"
                        >View all</a
                        ></span
                    >
                </div>
                <div class="dropdown-showbox">
                    <ul class="card-list" id="collection_${status.index}">
                        <li class="card-info-collection">
                            <a href="#" class="card-link">
                                <img
                                    src="./assets/images/logongan.png"
                                    alt=""
                                    class="card-image"
                                    />
                                <span class="card-name black-text-no-underline"
                                      >Category 1</span
                                >
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </li>
</c:forEach>
<li>
    <div class="header-with-logo-onmobile">
        <div class="header__logo">
            <a href="index.html"
               ><img
                    src="./assets/images/logodai.png"
                    class="header__logo-img"
                    alt="Logo"
                    /></a>
        </div>
    </div>
</li>
<div class="navbar__mobile-left">
    <li>
        <i
            class="header__navbar-icon fa fa-shopping-bag"
            aria-hidden="true"
            ></i
        ><i class="header__navbar-icon fa-regular fa-heart"></i>
    </li>
</div>
</ul>
<div class="search-hidden-box">
    <input type="text" placeholder="SEARCH" />
</div>
</div>
</div>
</nav>
</div>
</header>