<%-- 
    Document   : listProduct
    Created on : Jun 2, 2024, 11:41:55 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="body_category">



    <div class="product_container">
        <div class="product_container_row_1">
            <c:forEach items="${product}" var="product" varStatus="status">
                <div class="category_product_1">
                    <input type="hidden" id="product_${status.index}" value="${product_id}">
                    <img
                        class="product_img"
                        src="./product_img/${product.image}"
                        alt=""
                        />
                    <div class="product_describe_overlay" id="product_detail_${status.index}">
                        <p class="product_name">
                            B.ZERO1 RING
                        </p>
                        <p class="product_material">
                            Material
                            <br>
                            <span class="product_material_type">Rose gold</span>
                        </p>
                        <p class="product_germstone">
                            Germstone
                            <br>
                            <span class="product_germstone_type">Diamond</span>
                        </p>
                        <p class="product_price">
                            <span class="product_price_num">đ165,000,000</span>
                            <span class="product_price_taxes">Including Taxes</span>
                        </p>
                        <button class="product_discover_more">DISCOVER MORE</button>
                    </div>
                </div>
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