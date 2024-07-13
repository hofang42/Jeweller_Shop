<%-- 
    Document   : addproduct
    Created on : Jul 13, 2024, 12:46:38 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add Product</title>
    <link rel="stylesheet" href="./assets/css/dashboardpage.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@24,400,0,0"
    />
    <script>
      document.addEventListener("DOMContentLoaded", function () {
        const sideMenu = document.querySelector("aside");
        const menuBtn = document.getElementById("menu_bar");
        const closeBtn = document.getElementById("close_btn");

        menuBtn.addEventListener("click", () => {
          sideMenu.style.display = "block";
        });
        closeBtn.addEventListener("click", () => {
          sideMenu.style.display = "none";
        });
      });
      // Event delegation for sidebar links
      document
        .querySelector(".sidebar")
        .addEventListener("click", function (e) {
          if (e.target.closest("a")) {
            // Remove 'active' class from all links
            document
              .querySelectorAll(".sidebar a")
              .forEach((item) => item.classList.remove("active"));
            // Add 'active' class to the clicked link
            e.target.closest("a").classList.add("active");
          }
        });
    </script>
  </head>
  <body>
    <div class="container">
      <aside>
        <!-- Start top -->
        <div class="top">
          <div class="logo">
            <h2>RLoyal <span class="danger">Dashboard</span></h2>
          </div>
          <div class="close" id="close_btn">
            <span class="material-symbols-sharp"> close </span>
          </div>
        </div>
        <!-- End top -->
        <div class="sidebar">
          <a href="./dashboardpage.html">
            <span class="material-symbols-sharp">grid_view</span>
            <h3>Dashboard</h3>
          </a>

          <a href="#">
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
          <a href="">
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
          <a href="./addproduct.html" class="active">
            <span class="material-symbols-sharp">add</span>
            <h3>Add Product</h3>
          </a>
          <a href="#">
            <span class="material-symbols-sharp">logout</span>
            <h3>Logout</h3>
          </a>
        </div>
      </aside>
      <main>
        <h1>ADD PRODUCT</h1>
        <form action="/RloyalPRJ/upload" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <label for="product_name">Product Name</label>
            <input type="text" id="product_name" name="product_name" />
          </div>
          <div class="form-group">
            <label for="material">Material</label>
            <input type="text" id="material" name="material" />
          </div>
          <div class="form-group">
            <label for="gemstone">Gemstone</label>
            <input type="text" id="gemstone" name="gemstone" />
          </div>
          <div class="form-group">
            <label for="size">Size</label>
            <input type="text" id="size" name="size" />
          </div>
          <div class="form-group">
            <label for="resizeable">Resizeable</label>
            <input type="text" id="resizeable" name="resizeable" />
          </div>
          <div class="form-group">
            <label for="pendant">Pendant</label>
            <input type="text" id="pendant" name="pendant" />
          </div>
          <div class="form-group">
            <label for="diamond">Diamond</label>
            <input type="text" id="diamond" name="diamond" />
          </div>
          <div class="form-group">
            <label for="olfactive_family">Olfactive Family</label>
            <input type="text" id="olfactive_family" name="olfactive_family" />
          </div>
          <div class="form-group">
            <label for="colour">Color</label>
            <input type="text" id="colour" name="color" />
          </div>
          <div class="form-group">
            <label for="product_id">Product ID</label>
            <input type="number" id="product_id" name="product_id" />
          </div>
          <div class="form-group">
            <label for="product_full_desc">Product Full Description</label>
            <input
              type="text"
              id="product_full_desc"
              name="product_full_desc"
            />
          </div>
          <div class="form-group">
            <label for="product_small_desc">Product Small Description</label>
            <input
              type="text"
              id="product_small_desc"
              name="product_small_desc"
            />
          </div>
          <div class="form-group">
            <label for="original_price">Original Price</label>
            <input type="number" id="original_price" name="original_price" />
          </div>
          <div class="form-group">
            <label for="sale_price">Sale Price</label>
            <input type="number" id="sale_price" name="sale_price" />
          </div>
          <div class="form-group">
            <label for="product_category_id">Product Category Name:</label>
            <input
              type="text"
              id="product_category_id"
              name="product_category_id"
            />
          </div>
          <div class="form-group">
            <label for="product_collection_id">Product Collection Name:</label>
            <input
              type="text"
              id="product_collection_id"
              name="product_collection_id"
            />
          </div>
          <div class="form-group">
            <label for="image">Image URL:</label>
            <input type="file" id="image" name="image" />
          </div>
          <button type="submit">Add Product Info</button>
        </form>
      </main>
      <aside class="sidebar">
        <!-- Sidebar content -->
      </aside>
    </div>
    <script src="./assets/js/indexscript.js"></script>
  </body>
</html>
