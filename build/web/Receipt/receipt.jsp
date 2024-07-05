<%-- 
    Document   : receipt
    Created on : Jul 3, 2024, 1:28:07 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--Receipt-->
<<form action="/RloyalPRJ/home">
    <body class="receipt">
        <div class="receipt_container">
            <div class="receipt_title">
                <p>RECEIPT</p>
            </div>
            <div class="receipt_details">
                <div class="detail">
                    <div class="detail_title">Total Money:</div>
                    <div class="detail_info">đ ${total}</div>
                </div>
                <div class="detail">
                    <div class="detail_title">Receipt Code:</div>
                    <div class="detail_info">RECEIPT$${info.id}</div>
                </div>
                <div class="detail">
                    <div class="detail_title">Order Status:</div>
                    <div class="detail_info">${info.status}</div>
                </div>
            </div>
            <button class="confirm_button">CONFIRM</button>
        </div>
    </body>
</form>
<!--End Receipt-->