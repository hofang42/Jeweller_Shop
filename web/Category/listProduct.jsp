<%-- 
    Document   : listProduct
    Created on : Jun 2, 2024, 11:41:55 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="body_category">
    <div class="category_container_1">
        <div class="category_banner_1">
            <a href="">
                <p class="banner_title">B.ZERO1 JEWELRY</p>
                <img
                    class="banner_img"
                    src="assets/images/1920x1080-second-modal_kbilgp.avif"
                    alt=""
                    />
                <p class="banner_discover">DISCOVER</p>
            </a>
        </div>
        <c:forEach items="${requestScope.product}" var="product" begin="0" end="3">
            <c:if test="${product.product_id <= 4}">
                <div class="category_product_1">
                    <img
                        class="product_img"
                        src="./product_img/${product.image}"
                        alt=""
                        />
                </div>
            </c:if>
        </c:forEach>

    </div>

    <div class="category_container_2">
        <div class="category_banner_2">
            <a href="">
                <p class="banner_title">B.ZERO1 JEWELRY</p>
                <img
                    class="banner_img"
                    src="assets/images/1920x1080-second-modal_kbilgp.avif"
                    alt=""
                    />
                <p class="banner_discover">DISCOVER</p>
            </a>
        </div>
        <c:forEach items="${requestScope.product}" var="pro" begin="0" end="7">
            <c:if test="${pro.product_id > 4}">
                <div class="category_product_2">
                    <img
                        class="product_img"
                        src="./product_img/${pro.image}"
                        alt=""
                        />      
                </div>
            </c:if>
        </c:forEach>


    </div>

    <div class="product_container">
        <div class="product_container_row_1">
            <c:forEach items="${product}" var="product">
                <c:if test="${product.product_id > 8}">
                    <div class="product_img">
                        <img src="./product_img/${product.image}" alt="" />
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <input type="checkbox" name="" id="ch" />
        <div class="product_container_row_2">
            <div class="product_img">
                <img src="assets/images/1448229.avif" alt="" />
            </div>

            <div class="product_img">
                <img src="assets/images/454302.avif" alt="" />
            </div>

            <div class="product_img">
                <img src="assets/images/1476152.avif" alt="" />
            </div>

            <div class="product_img">
                <img src="assets/images/1530582.avif" alt="" />
            </div>
        </div>
        <label for="ch">SEE MORE</label>
    </div>
</div>
</body>
<!--End Body_category-->