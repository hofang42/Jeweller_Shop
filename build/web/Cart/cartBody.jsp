<%-- 
    Document   : cartBody
    Created on : Jul 2, 2024, 2:37:38 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<
<body class="shopping_bag">
    <div class="shopping_bag_title">
        <p>SHOPPING BAG</p>
    </div>
    <form action="/RloyalPRJ/buy" method="post">
        <div class="shopping_bag_container">
            <div class="item_container">
                <c:forEach items="${cart}" var="data" varStatus="status">
                    <div class="item_1_container">
                            <div class="remove_button">
                                <a href="/RloyalPRJ/remove?rId=${data.product.product_id}">Remove</a>
                            </div>
                        <div class="item_1_info">

                            <div class="item_1_img_name">
                                <img class="item_img" src="./product_detail_img/${data.product.product_name}/${data.img_link.img_link}" alt="">
                                <div class="item_name">${data.product.product_name}</div> 
                            </div>

                            <div class="item_quantity" style="">
                                <span id="minus_${status.index}" onclick="decrease(${status.index})">-</span>
                                <input type="text" id="num_${status.index}" name="num_${status.index}" value="1">
                                <span id="plus_${status.index}" onclick="increase(${status.index})" > + </span>
                            </div>
                            <div class="item_price">
                                <div class="price">PRICE</div>
                                <input type="hidden" name="price" id="price_${status.index}" value="${data.product.original_price}">
                                <div class="money">đ ${data.product.original_price}</div>
                            </div>

                            <div class="item_size_code">

                                <div class="item_size">
                                    <div class="item_size_title">SIZE</div>
                                    <div class="size">${data.size}</div>
                                </div>

                                <div class="item_code">
                                    <div class="item_code_title">PRODUCT CODE</div>
                                    <div class="code">${data.product.product_id}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="order_summary_container">
                <p class="order_summary_title">ORDER SUMMARY</p>
                <div class="total">
                    <div class="total_title">TOTAL</div>
                    <input type="hidden" id="price" name="total_Money" value="${price}">
                    <div class="total_money" id="totalMoney">${price}</div>
                </div>
                <button class="check_out_button" type="submit">CHECK OUT</button>
                <button class="continue_button">CONTINUE SHOPPING</button>
            </div>
        </div>
    </form>
</body>

