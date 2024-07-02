<%-- 
    Document   : checkOutBody
    Created on : Jul 2, 2024, 2:49:13 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start Body -->
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
            <h5 class="bold-text">Total: ${total}</h5>
        </div>
    </div>
    <div class="body-contain row">
        <div class="body-checkout col-md-6">
            <form action="">
                <div class="row">
                    <div class="column">
                        <h3 class="title">Billing Address</h3>
                        <div class="input-box">
                            <span>Full Name :</span>
                            <input type="text" placeholder="Tran Van Hoang Phuc" />
                        </div>
                        <div class="input-box">
                            <span>Email :</span>
                            <input
                                type="email"
                                placeholder="phuctvhde180xxx@fpt.edu.vn"
                                />
                        </div>
                        <div class="input-box">
                            <span>Address :</span>
                            <input type="text" placeholder="Room - Street - Locality" />
                        </div>
                        <div class="input-box">
                            <span>City :</span>
                            <input type="text" placeholder="Da Nang" />
                        </div>
                        <div class="flex">
                            <div class="input-box">
                                <span>State :</span>
                                <input type="text" placeholder="Hoa Hai" />
                            </div>
                            <div class="input-box">
                                <span>Zip Code :</span>
                                <input type="number" placeholder="123 456" />
                            </div>
                        </div>
                    </div>

                    <div class="column">
                        <h3 class="title">Payment</h3>
                        <div class="input-box">
                            <span>Cards Accepted :</span>
                            <img src="./assets/images/imgcards.png" alt="" />
                        </div>
                        <div class="input-box">
                            <span>Name On Card :</span>
                            <input type="text" placeholder="Tran Van Hoang Phuc" />
                        </div>
                        <div class="input-box">
                            <span>Credit Card Number :</span>
                            <input type="number" placeholder="1111 2222 3333 4444" />
                        </div>
                        <div class="input-box">
                            <span>Exp. Month :</span>
                            <input type="text" placeholder="August" />
                        </div>
                        <div class="flex">
                            <div class="input-box">
                                <span>Exp. Year :</span>
                                <input type="numer" placeholder="2025" />
                            </div>
                            <div class="input-box">
                                <span>CVV :</span>
                                <input type="number" placeholder="123" />
                            </div>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btnsubmit">Submit</button>
            </form>
        </div>
        <div class="delivery-address col-md-6">
            <form action="">
                <div class="row">
                    <div class="column">
                        <h3 class="title">DELIVERY ADDRESS</h3>
                        <div class="input-box">
                            <span>First Name :</span>
                            <input type="text" placeholder="Phuc" />
                        </div>
                        <div class="input-box">
                            <span>Last Name :</span>
                            <input type="text" placeholder="Tran Van Hoang " />
                        </div>
                        <div class="input-box">
                            <span>Address :</span>
                            <input type="text" placeholder="Room - Street - Locality" />
                        </div>
                        <div class="input-box">
                            <span>Mobile Phone</span>
                            <input type="number" placeholder="123 456 7890" />
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>