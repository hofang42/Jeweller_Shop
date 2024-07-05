<%-- 
    Document   : checkOutBody
    Created on : Jul 2, 2024, 2:49:13 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start Body -->
<form action="/RloyalPRJ/checkout" method="post">
    <div class="container-fluid">
        <div class="header-checkout col-md-12">
            <div class="order-summary">
                <table>
                    <thead>
                        <tr>
                            <th colspan="2" class="bold-text">Order Summary</th>
                            <th>Quantity</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${product}" var="product">
                            <tr>
                                <td><img src="./product_detail_img/${product.product.product_name}/${product.img_link.img_link}" alt="" /></td>
                                <td>${product.product.product_name}</td>
                                <td class="bold-text">${product.quantity}</td>
                                <td class="bold-text">${product.product.original_price}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="total-money">
                <input type="hidden" name="total" value="${total}">
                <h5 class="bold-text">Total: ${total}</h5>
            </div>
        </div>
        <div class="body-contain row">
            <div class="body-checkout col-md-12">
                <div class="row">
                    <div class="column">
                        <h3 class="title">DELIVERY ADDRESSs</h3>
                        <div class="input-box">
                            <span>Full Name :</span>
                            <input type="hidden" name="user_id" value="${sessionScope.acc.user_id}${sessionScope.accGoogle.id}">
                            <input type="text" name="full_name" placeholder="Tran Van Hoang Phuc" required="The field is required." />
                        </div>
                        <div class="input-box">
                            <span>Email :</span>
                            <input
                                type="email"
                                name="email"
                                placeholder="phuctvhde180xxx@fpt.edu.vn"
                                />
                        </div>
                        <div class="input-box">
                            <span>Address :</span>
                            <input type="text" name="address" placeholder="Room - Street - Locality" required="The field is required."/>
                        </div>
                        <div class="input-box">
                            <span>City :</span>
                            <input type="text" name="city" placeholder="Da Nang" required="The field is required."/>
                        </div>
                        <div class="input-box">
                            <span>Mobile Phone</span>
                            <input type="number" name="phone" placeholder="123 456 7890" required="The field is required."/>
                        </div>
                        <div class="flex">
                            <div class="input-box">
                                <span>State :</span>
                                <input type="text" name="state" placeholder="Hoa Hai" required="The field is required."/>
                            </div>
                            <div class="input-box">
                                <span>Zip Code :</span>
                                <input type="number" name="zip_code" placeholder="123 456" required="The field is required."/>
                            </div>
                        </div>
                        <div>
                            <input type="submit" value="Submit" />
                        </div>
                    </div>
                    <div class="column">
                        <h3 class="title">Payment</h3>
                        <input type="radio" name="direct" value="A"> Thanh toán trực tiếp
                        <input type="radio" name="vnpay" value="A" > VNPAY
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
