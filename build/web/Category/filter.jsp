<%-- 
    Document   : filter
    Created on : Jun 2, 2024, 12:28:54 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Start Body_category-->
<body class="body_category_page">
    <div class="body_head">
        <div class="body_head_sec_1">
            <a href="index.html">HOME</a>
        </div>

        <div class="body_head_sec_2">
            <p>FINE JEWELLERY ONLINE</p>
        </div>

        <div class="body_head_sec_3">
            <button onclick="location.href = 'index.html';">Bracelets</button>

            <button onclick="location.href = 'index.html';">Cufflinks</button>

            <button onclick="location.href = 'index.html';">Earrings</button>

            <button onclick="location.href = 'index.html';">Necklaces</button>

            <button onclick="location.href = 'index.html';">Pendants</button>

            <button onclick="location.href = 'index.html';">Rings</button>

            <button onclick="location.href = 'index.html';">Wedding Rings</button>
        </div>

        <div class="body_head_sec_4">
            <div class="body_head_sec_4_A">
                <p>Showing 36 of 401</p>
            </div>

            <div class="body_head_sec_4_B">
                <label for="">Sort by: </label>
                <select name="" id="">
                    <option value="">None</option>
                    <option value="">Recommended</option>
                    <option value="">Best seller</option>
                    <option value="">Price High to Low</option>
                    <option value="">Price Low to High</option>
                    <option value="">New Arrivals</option>
                </select>
            </div>
        </div>

        <div class="body_head_sec_5">
            <p>
                <i class="fa-solid fa-filter"></i>
                Filter by:
            </p>

            <div class="body_head_sec_5_category">
                <button
                    onclick="toggleDropdown('categoryDropdown')"
                    class="dropbtn"
                    >
                    Category
                    <i
                        for="rotateCheckbox"
                        id="rotateButton"
                        class="fa-solid fa-caret-down"
                        ></i>
                </button>
                <div id="categoryDropdown" class="dropdown-content">
                    <ul class="category_dropdown">
                        <li>
                            <a href="index.html">
                                <span>Bracelets (60)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Cufflinks (5)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Earrings (50)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Necklaces (142)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Pendant (1)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Rings (114)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Wedding Rings (21)</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="body_head_sec_5_collection">
                <button
                    onclick="toggleDropdown('collectionDropdown')"
                    class="dropbtn"
                    >
                    Collection
                    <i class="fa-solid fa-caret-down"></i>
                </button>
                <div id="collectionDropdown" class="dropdown-content">
                    <ul class="collection_dropdown">
                        <li>
                            <a href="index.html">
                                <span>Allegra (5)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>B.zero1 (117)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Bvlgari Bvlgari (46)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Bvlgari Cabochon (4)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Corona (1)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Croce (1)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Divas’ Dream (68)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Fedi (5)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Fiorever (34)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Griffe (1)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Incontro d’Amore (2)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Infinito (5)</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="body_head_sec_5_color">
                <button onclick="toggleDropdown('colorDropdown')" class="dropbtn">
                    Color
                    <i class="fa-solid fa-caret-down"></i>
                </button>
                <div id="colorDropdown" class="dropdown-content">
                    <ul class="color_dropdown">
                        <li>
                            <a href="index.html">
                                <span>Pink (12)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Yellow (8)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>White (50)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Black (40)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Blue (13)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Bronze (2)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Green (38)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Orange (1)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Red (20)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Light Blue (1)</span>
                            </a>
                        </li>

                        <li>
                            <a href="index.html">
                                <span>Multicolor (9)</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>