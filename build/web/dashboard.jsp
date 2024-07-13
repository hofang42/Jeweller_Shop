<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@24,400,0,0"
            />
        <link rel="stylesheet" href="./assets/css/dashboardpage.css" />
    </head>
    <body>
        <div class="container">
            <!-- aside section start -->
            <aside>
                <!-- Start top -->
                <div class="top">
                    <div class="logo">
                        <h2>RLoyal <span class="danger">Dashboard</span></h2>
                    </div>
                    <div class="close">
                        <span class="material-symbols-sharp"> close </span>
                    </div>
                </div>
                <!-- End top -->
                <div class="sidebar">
                    <a href="#">
                        <span class="material-symbols-sharp">grid_view</span>
                        <h3>Dashboard</h3>
                    </a>

                    <a href="#" class="active">
                        <span class="material-symbols-sharp">person_outline</span>
                        <h3>Customer</h3>
                    </a>
                    <a href="#">
                        <span class="material-symbols-sharp">insights</span>
                        <h3>Analytics</h3>
                    </a>
                    <a href="#">
                        <span class="material-symbols-sharp">mail_outline</span>
                        <h3>Messages</h3>
                        <span class="msg_count">14</span>
                    </a>
                    <a href="#">
                        <span class="material-symbols-sharp">receipt_long</span>
                        <h3>Products</h3>
                    </a>
                    <a href="#">
                        <span class="material-symbols-sharp">report_gmailerrorred</span>
                        <h3>Reports</h3>
                    </a>
                    <a href="#">
                        <span class="material-symbols-sharp">settings</span>
                        <h3>Settings</h3>
                    </a>
                    <a href="#">
                        <span class="material-symbols-sharp">add</span>
                        <h3>Add Product</h3>
                    </a>
                    <a href="/RloyalPRJ/home">
                        <span class="material-symbols-sharp">logout</span>
                        <h3>Logout</h3>
                    </a>
                </div>
            </aside>
            <!-- aside section end -->

            <!-- main section start -->
            <main>
                <h1>Dashboard</h1>
                <div class="date">
                    <input type="date" id="date" onchange=" GetProductByDate(), GetTotalProduct()"/>
                </div>
                <!-- Start Insight -->
                <div class="insights">
                    <!-- Start selling  -->
                    <div class="sales" id="sale_total">
                        <span class="material-symbols-sharp">trending_up</span>
                        <div class="middle">
                            <div class="left">
                                <h3>Total Sales</h3>
                                <h1>$${total}</h1>
                            </div>
                            <div class="progress">
                                <svg>
                                <circle r="30" cy="40" cx="40"></circle>
                                </svg>
                                <div class="number">80%</div>
                            </div>
                            <small>Last 24 hours</small>
                        </div>
                    </div>
                    <!-- End Incomes  -->
                </div>
                <!-- End Insight -->
                <!-- Start recent order -->
                <div class="recent_oder" id="product_list">
                    <h1>Recent Orders</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Product ID</th>
                                <th>Amounts</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${data}" var="data">
                                <tr>
                                    <td><c:out value="${data.product_name}" /></td>
                                    <td><c:out value="${data.product_id}" /></td>
                                    <td><c:out value="${data.price}" /></td>
                                    <td><c:out value="${data.status}" /></td>
                                    <td class="primary">Details</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- End recent order -->
            </main>
            <!-- main section end -->
            <!-- right section start -->    
            <!-- end right -->
        </div>

        <script src="./assets/js/indexscript.js"></script>
    </body>

    <script type="text/javascript">
        function GetProductByDate() {
            var date = document.getElementById("date").value;
            $.ajax({
                url: "/RloyalPRJ/loadProduct",
                type: "post",
                data: {
                    date: date
                },
                success: function (data) {
                    var row = document.getElementById("product_list");
                    row.innerHTML = data;
                }
            });

        }
    </script>
    
    <script type="text/javascript">
        function GetTotalProduct() {
            var date = document.getElementById("date").value;
            $.ajax({
                url: "/RloyalPRJ/loadProduct",
                type: "get",
                data: {
                    date: date
                },
                success: function (data) {
                    var row = document.getElementById("sale_total");
                    row.innerHTML = data;
                }
            });

        }
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</html>
