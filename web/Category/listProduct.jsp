<%-- 
    Document   : listProduct
    Created on : Jun 2, 2024, 11:41:55 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="body_category">
    <div class="product_container">
        <div class="product_container_row_1" id="product">
            <c:forEach items="${product}" var="product" varStatus="status">
                <input type="hidden" id="product_id_${status.index}" value="${product.product_id}">
                <div class="productItem category_product_1" >
                    <img onmouseover="Product_describe(${status.index})"
                        class="product_img"
                        src="./product_detail_img/${product.product_name}/${product.image}"
                        alt=""
                        />
                    <div class="product_describe_overlay" id="product_describe_${status.index}">
                        <p class="product_name">
                            B.ZERO1 RING
                        </p>
                        <p class="product_material">
                            Material
                            <br>
                            <span class="product_material_type">Rose gold</span>
                        </p>
                        <p class="product_germstone">
                            Gemstone
                            <br>
                            <span class="product_germstone_type">Diamond</span>
                        </p>
                        <p class="product_price">
                            <span class="product_price_num">đ165,000,000</span>
                            <span class="product_price_taxes">Including Taxes</span>
                        </p>
                        <a href="/RloyalPRJ/productDetail?pId=${product.product_id}" class="product_discover_more">DISCOVER MORE</a>                   
                    </div>
                </div>
            </c:forEach>
        </div>
        <input type="checkbox" name="" id="ch" />
        <label for="ch" onclick="LoadMore()">SEE MORE</label>
    </div>
</div>
</body>
<!--End Body_category-->