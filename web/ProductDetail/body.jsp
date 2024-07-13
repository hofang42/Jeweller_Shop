<%-- 
    Document   : ProductInfo
    Created on : Jun 26, 2024, 3:46:02 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    <div class="product__detail-top col">
        <div class="product__detail-left col-md-6 col-12">
            <c:forEach items="${img}" var="img" begin="1" end="1">
                <div class="product__detail-big-img">
                    <img
                        src="./product_detail_img/${product.product_name}/${img}"
                        alt=""
                        id="featured"
                        />
                </div>
            </c:forEach>
            <div class="product__detail-wrapper" id="slider">
                <img
                    src="./assets/images/left-arrow.png"
                    class="arrow"
                    id="slideLeft"
                    />
                <div class="product__detail-slider">
                    <c:forEach items="${img}" var="img">
                        <img
                            src="./product_detail_img/${product.product_name}/${img}"
                            alt="Slide"
                            class="product__detail-thumbnail active"
                            />

                    </c:forEach>
                </div>
                <img
                    src="./assets/images/right-arrow.png"
                    class="arrow"
                    id="slideRight"
                    />
            </div>
        </div>

        <div class="product__detail-right col-md-6 col-12">
            <div class="product__detail-product-name">
                <h1>${product.product_name}</h1>
            </div>
            <div class="product__detail-product-sub-descrip">
                <h2>
                    ${product.product_small_desc}
                </h2>
            </div>
            <div class="product__detail-price">
                <div>
                    <span class="shoppable-price">đ ${product.price}</span>
                </div>
                <div>
                    <span class="tax">Including Taxes</span>
                </div>
            </div>
            <form action="/RloyalPRJ/cart" method="post">
                <div class="product__detail-size-pick">
                    <select name="size" id="" class="custom-select">
                        <option value="0">Pick your size</option>
                        <option value="52">52</option>
                        <option value="53">53</option>
                        <option value="54">54</option>
                        <option value="55">55</option>
                    </select>
                </div>
                <div class="product__detail-add-label-info">
                    <svg
                        id="shipping"
                        data-name="Livello 1"
                        xmlns="http://www.w3.org/2000/svg"
                        viewBox="0 0 48.41 36.88"
                        width="26px"
                        height="26px"
                        >
                    <defs>
                    <style>
                        .cls-1 {
                            fill: #010101;
                        }
                    </style>
                    </defs>
                    <path
                        class="cls-1"
                        d="M322.18,417.93,319,410.32H308.57v-8.27H273.8v30H281a4.77,4.77,0,0,0-.06.76,5.86,5.86,0,0,0,11.71,0,4.77,4.77,0,0,0-.06-.76h16.1a5.39,5.39,0,0,0-.09,1,5.86,5.86,0,0,0,11.71,0,6.41,6.41,0,0,0-.09-1h2V417.93Zm-35.41,19.15a4.12,4.12,0,1,1,4.11-4.11A4.11,4.11,0,0,1,286.77,437.08Zm19.48-26.75v19.44H291.74a5.84,5.84,0,0,0-9.95,0h-5.67V404.38h30.13Zm2.32,2.32H318l2.19,5.28H308.57Zm5.85,24.55a4.12,4.12,0,1,1,4.12-4.11A4.11,4.11,0,0,1,314.42,437.2Zm6-7.43h-1.2a5.84,5.84,0,0,0-9.64,0h-1V419.69h11.87Z"
                        transform="translate(-273.8 -402.06)"
                        ></path>
                    </svg>
                    <span class="benefit"
                          >Complimentary Insured Express Shipping
                    </span>
                </div>
                <div class="product__detail-add-label-info">
                    <svg
                        width="26px"
                        height="26px"
                        viewBox="0 0 26 26"
                        version="1.1"
                        xmlns="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        >
                    <title>exchanges and returns</title>
                    <g
                        id="Category-icons"
                        stroke="none"
                        stroke-width="1"
                        fill="none"
                        fill-rule="evenodd"
                        >
                    <g
                        id="Category-icons-48x48-Copy"
                        transform="translate(-1233.000000, -7.000000)"
                        >
                    <g
                        id="exchanges-and-returns"
                        transform="translate(1234.000000, 8.050000)"
                        >
                    <path
                        d="M22.4,1.975 L22.7,2.275 C22.8,2.375 22.8,2.475 22.7,2.575 L20.3,4.875 C20.2,4.975 20.1,4.975 20,4.875 L18.8,3.675 C18.7,3.575 18.7,3.475 18.8,3.375 L19.1,3.075 C19.2,2.975 19.3,2.975 19.4,3.075 L20.1,3.775 L22,1.875 C22.2,1.875 22.3,1.875 22.4,1.975"
                        id="Fill-1"
                        fill="#1F1F1F"
                        ></path>
                    <path
                        d="M22.7,0.675 C23,0.775 23.4,0.975 23.8,1.175 C23.9,1.175 23.9,1.275 23.9,1.375 L23.9,4.175 C23.9,4.475 23.8,4.775 23.7,4.975 C23.1,6.075 21.9,6.875 20.9,7.575 C20.9,7.575 20.8,7.575 20.8,7.575 C20.7,7.575 20.7,7.575 20.7,7.575 C19.7,6.875 18.5,6.075 17.8,4.975 C17.7,4.775 17.6,4.475 17.6,4.175 L17.6,1.375 C17.6,1.275 17.7,1.175 17.7,1.175 C18.1,0.975 18.5,0.775 18.8,0.675 C20.7,-0.225 20.8,-0.225 22.7,0.675 Z"
                        id="Stroke-3"
                        stroke="#1F1F1F"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        ></path>
                    <polyline
                        id="Stroke-5"
                        stroke="#1F1F1F"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        points="0 13.975 0 11.975 9 11.975 18 11.975 18 17.975 18 23.975 9 23.975 0 23.975 0 16.975 8 16.975"
                        ></polyline>
                    <polygon
                        id="Stroke-7"
                        stroke="#1F1F1F"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        points="18 11.975 9 11.975 0 11.975 1 8.975 2 5.975 9 5.975 16 5.975 17 8.975"
                        ></polygon>
                    <polygon
                        id="Stroke-9"
                        stroke="#1F1F1F"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        points="8 18.975 9.5 17.975 11 16.975 9.5 15.975 8 14.975 8 16.975"
                        ></polygon>
                    <line
                        x1="9"
                        y1="11.975"
                        x2="9"
                        y2="5.975"
                        id="Stroke-11"
                        stroke="#1F1F1F"
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        ></line>
                    </g>
                    </g>
                    </g>
                    </svg>

                    <span class="benefit">Complimentary Returns & Exchanges</span>
                </div>
                <div class="button__add-to-cart">
                    <div class="button__add-to-cart-btn">
                        <input type="hidden" value="${product.product_id}" name="pId">
                        <input type="submit" name="addCart" class="btn-add-cart" value="ADD TO CART">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="backspace-between"></div>
    <div class="product__detail-bottom row">
        <div class="product__detail-full-descrip col-md-6 col-sm-12">
            <div class="full-descrip-title"><h1>Description</h1></div>
            <div class="full-descrip-para">
                <p>
                    ${product.product_full_desc}
                </p>
            </div>
        </div>
        <!-- <div class="cell divider-cell">
          <div class="description-details-divider"></div>
        </div> -->
        <div class="product__detail-full-descrip col-md-6 col-sm-12">
            <div class="full-detail-title"><h1>Detail</h1></div>
            <div class="full-detail-para">
                <ul class="details-list">
                    <c:if test="${product.material != null}">
                        <li>
                            <span class="detail-icon">🏷️</span>
                            <strong>Material:</strong> ${product.material}
                        </li>
                    </c:if>
                    <c:if test="${product.gemstone != null}">
                        <li>
                            <span class="detail-icon">💍</span>
                            <strong>Gemstone:</strong> ${product.gemstone}
                        </li>
                    </c:if>
                    <c:if test="${product.diamond != null}">
                        <li>
                            <span class="detail-icon">💎</span>
                            <strong>Diamonds (Carats):</strong> ${product.diamond}
                        </li>
                    </c:if>
                    <c:if test="${product.size != null}">
                        <li>
                            <span class="detail-icon">📏</span> <strong>Size:</strong> ${product.size}
                        </li>
                    </c:if>
                    <c:if test="${product.resizable != null}">
                        <li>
                            <span class="detail-icon">🔧</span>
                            <strong>Resizable:</strong> ${product.resizable}
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>