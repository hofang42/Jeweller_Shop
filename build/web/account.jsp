<%-- 
    Document   : account
    Created on : Jul 4, 2024, 9:12:56 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/Home/header.jsp"%>
<%@include file="/Home/category.jsp" %>
<body>
    <div class="account-page">
      <h1>MY ACCOUNT</h1>
      <p class="subtitle">
        Please tell us about your preferences and special occasions by editing
        your personal information. We would love to share your celebration with
        exclusive content and surprises. Stay tuned!
      </p>
      <div class="account-section">
        <div class="personal-info">
          <h2>
            YOUR PERSONAL INFORMATION <a href="./editprofile.html">Edit</a>
          </h2>
            <p>First Name: ${sessionScope.acc.user_firstname}${sessionScope.accGoogle.given_name}</p>
            <p>Last Name: ${sessionScope.acc.user_lastname}${sessionScope.accGoogle.family_name}</p>
          <p>E-mail Address: ${sessionScope.acc.user_email}${sessionScope.accGoogle.email}</p>
          <p>Phone:</p>
        </div>

        <div class="password">
          <h2>PASSWORD <a href="./editpassword.html">Edit</a></h2>
          <p>Password: ********</p>
        </div>
      </div>
    </div>
  </body>
  <%@include file="/Home/footer.jsp" %>