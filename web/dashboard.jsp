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
          <a href="#">
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
          <input type="date" />
        </div>
        <!-- Start Insight -->
        <div class="insights">
          <!-- Start selling  -->
          <div class="sales">
            <span class="material-symbols-sharp">trending_up</span>
            <div class="middle">
              <div class="left">
                <h3>Total Sales</h3>
                <h1>$100.000</h1>
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
          <!-- End selling  -->
          <!-- Start Expenses  -->
          <div class="expense">
            <span class="material-symbols-sharp">local_mall</span>
            <div class="middle">
              <div class="left">
                <h3>Total Expenses</h3>
                <h1>$100.000</h1>
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
          <!-- End Expenses  -->
          <!-- Start Incomes  -->
          <div class="income">
            <span class="material-symbols-sharp">stacked_line_chart</span>
            <div class="middle">
              <div class="left">
                <h3>Income</h3>
                <h1>$100.000</h1>
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
        <div class="recent_oder">
          <h1>Recent Orders</h1>
          <table>
            <thead>
              <tr>
                <th>Product Name</th>
                <th>Product ID</th>
                <th>Payments</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Golden Rings</td>
                <td>1</td>
                <td>Due</td>
                <td class="warning">Pending</td>
                <td class="primary">Details</td>
              </tr>

              <tr>
                <td>Golden Rings</td>
                <td>1</td>
                <td>Due</td>
                <td class="warning">Pending</td>
                <td class="primary">Details</td>
              </tr>

              <tr>
                <td>Golden Rings</td>
                <td>1</td>
                <td>Due</td>
                <td class="warning">Pending</td>
                <td class="primary">Details</td>
              </tr>

              <tr>
                <td>Golden Rings</td>
                <td>1</td>
                <td>Due</td>
                <td class="warning">Pending</td>
                <td class="primary">Details</td>
              </tr>
            </tbody>
          </table>
        </div>
        <!-- End recent order -->
      </main>
      <!-- main section end -->
      <!-- right section start -->
      <div class="right">
        <h1>Right</h1>
      </div>
      <!-- end right -->
    </div>

    <script src="./assets/js/indexscript.js"></script>
  </body>
</html>
