<%-- 
    Document   : header
    Created on : Jun 1, 2024, 12:33:30 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>RLoyal</title>

    <link rel="stylesheet" href="./assets/css/normalize.css" />
    <link rel="stylesheet" href="./assets/css/base.css" />
    <link rel="stylesheet" href="./assets/css/main.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      rel="stylesheet"
      href="./assets/fonts/fontawesome-free-6.5.2-web/fontawesome-free-6.5.2-web/css/all.min.css"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto:wght@300;400;500;700;900&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@0,100..900;1,100..900&display=swap"
      rel="stylesheet"
    />

    <link
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link rel="icon" type="image/x-icon" href="./assets/images/favicon.png" />
  </head>
  <body>
    <!-- Header -->
    <div class="app">
      <header class="" id="header">
        <div class="grid">
          <!-- Hamburger menu icon for smaller screens -->

          <nav class="header__navbar">
            <div class="header__navbar-container">
              <ul class="header__navbar-list header__navbar-list--right">
                <li
                  class="header__navbar-item header__navbar-item--seperate header__navbar-item-responsive"
                >
                  <i class="header__navbar-icon fa-solid fa-bell-concierge"></i>
                  Services
                </li>
                <li class="header__navbar-item header__navbar-item-responsive">
                  <span class="header__navbar-title--no-pointer" -
                    >Connect us</span
                  >
                  <a
                    href="https://facebook.com/hofang42"
                    class="header__navbar-icon-link"
                  >
                    <i class="header__navbar-icon fa-brands fa-facebook"></i>
                  </a>
                  <a href="" class="header__navbar-icon-link">
                    <i class="header__navbar-icon fa-brands fa-instagram"></i>
                  </a>
                </li>
                <li class="header__navbar-item">
                  <i
                    class="header__navbar-icon fa-solid fa-magnifying-glass"
                  ></i>
                  <input
                    type="text"
                    class="header__navbar--searchbox"
                    placeholder="SEARCH"
                  />
                </li>
              </ul>

              <ul class="header__navbar-list header__navbar-list--left">
                <!-- <li
                class="header__navbar-item header__navbar-item--strong header__navbar-item--seperate"
              >
                <i class="header__navbar-icon fa-solid fa-user"></i>
                <a href="./login.html" class="header__navbar-item-link"
                  >Sign in</a
                >
              </li>
              <li
                class="header__navbar-item header__navbar-item--strong header__navbar-item--seperate"
              >
                <i class="header__navbar-icon fa-regular fa-user"></i>
                <a href="./register.html" class="header__navbar-item-link"
                  >Sign up</a
                >
              </li> -->
                <li class="header__navbar-item header__navbar-user">
                  <img
                    src="https://scontent.fdad1-3.fna.fbcdn.net/v/t39.30808-1/356897934_777936193800003_6546687517946988960_n.jpg?stp=dst-jpg_p100x100&_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFY2tcIFAsxFwb3EW_JgdyukEEFnMPttrqQQQWcw-22usKY3UkBKkmXR3bD_fQXKp7Y0cXi1VtVydDVeWI3CCsZ&_nc_ohc=mLV6n1XXQpwQ7kNvgFaqkKf&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.fdad1-3.fna&oh=00_AYA4-CRiHQmRgmNXdcgSKC87LKIuMnaR30VX-4EsawbNxQ&oe=6655EFAD"
                    alt="Avt"
                    class="header__navbar-user-img"
                  />
                  <span class="header__navbar-user-name">Khanh Pham </span>
                  <ul class="header__navbar-user-menu">
                    <li class="header__navbar-user-item">
                      <a href="">My Account</a>
                    </li>
                    <li class="header__navbar-user-item">
                      <a href="">Log out</a>
                    </li>
                  </ul>
                </li>
                <li class="header__navbar-item">
                  <i
                    class="header__navbar-icon fa fa-shopping-bag"
                    aria-hidden="true"
                  ></i>
                  <a href="" class="header__navbar-item-link">
                    Shopping bags
                  </a>
                </li>
                <li class="header__navbar-item">
                  <i class="header__navbar-icon fa-regular fa-heart"></i>
                  <a href="#" class="header__navbar-item-link">My Wishlist</a>
                </li>
              </ul>
            </div>
          </nav>
          <div class="header-with-logo">
            <div class="header__logo">
              <a href="index.html"
                ><img
                  src="./assets/images/logodai.png"
                  class="header__logo-img"
                  alt="Logo"
              /></a>
            </div>
          </div>
          <nav class="header__navbar">
            <div class="header-with-dropdown">
              <div class="header__dropdown-list">
                <ul class="sidebar">
                  <li onclick="hideSidebar()">
                    <a href="#"
                      ><svg
                        xmlns="http://www.w3.org/2000/svg"
                        height="24px"
                        viewBox="0 -960 960 960"
                        width="24px"
                        fill="#000"
                      >
                        <path
                          d="m256-200-56-56 224-224-224-224 56-56 224 224 224-224 56 56-224 224 224 224-56 56-224-224-224 224Z"
                        /></svg
                    ></a>
                  </li>
                  <li class="header__dropdown-item">HIGH JEWELLERY</li>
                  <li class="header__dropdown-item">JEWELLERY</li>
                  <li class="header__dropdown-item">ENGAGEMENT & WEDDING</li>
                  <li class="header__dropdown-item">WATCHES</li>
                  <li class="header__dropdown-item">BAGS & ACCESSORIES</li>
                  <!-- USER NAVBAR -->
                  <div class="navbar__for-user">
                    <li class="header__navbar-item">
                      <i class="header__navbar-icon fa-solid fa-user"></i>
                      <a href="./login.html" class="header__navbar-item-link"
                        >My Account</a
                      >
                    </li>
                    <li class="header__navbar-item">
                      <i class="header__navbar-icon fa-regular fa-heart"></i>
                      <a href="#" class="header__navbar-item-link"
                        >My Wishlist</a
                      >
                    </li>
                    <li class="header__navbar-item">
                      <i
                        class="header__navbar-icon fa-solid fa-bell-concierge"
                      ></i>
                      <a href="#" class="header__navbar-item-link">Services</a>
                    </li>
                    <li class="header__navbar-item">
                      <i
                        class="header__navbar-icon fa-solid fa-address-book"
                      ></i>
                      <a href="#" class="header__navbar-item-link">Contact</a>
                    </li>
                  </div>
                </ul>
              </div>
            </div>
          </nav>
          <nav class="header__navbar">
            <div class="header-with-dropdown">
              <div class="header__dropdown-list">
                <ul class="header__dropdown-list--list">
                  <div class="navbar__mobile-right">
                    <li class="menu-button" onclick="showSidebar()">
                      <a href="#"
                        ><svg
                          xmlns="http://www.w3.org/2000/svg"
                          height="31px"
                          viewBox="0 -960 960 960"
                          width="31px"
                          fill="#000"
                        >
                          <path
                            d="M120-240v-80h720v80H120Zm0-200v-80h720v80H120Zm0-200v-80h720v80H120Z"
                          /></svg
                      ></a>
                    </li>
                    <div class="header__navbar-search-onmobile">
                      <i
                        class="header__navbar-icon fa-solid fa-magnifying-glass"
                      ></i>
                    </div>
                  </div>
