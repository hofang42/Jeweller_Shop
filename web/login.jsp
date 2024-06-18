<%-- 
    Document   : login
    Created on : Jun 10, 2024, 10:42:05 AM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
            />
        <link rel="stylesheet" href="./assets/css/loginstyle.css" />
        <title>Modern Login Page | AsmrProg</title>
    </head>

    <body>
        <div class="container" id="container">
            <div class="form-container sign-up">
                <form>
                    <h1>Create Account</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"
                           ><i class="fa-brands fa-google-plus-g"></i
                            ></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"
                           ><i class="fa-brands fa-linkedin-in"></i
                            ></a>
                    </div>
                    <span>or use your email for registeration</span>
                    <input type="text" placeholder="Name" />
                    <input type="email" placeholder="Email" />
                    <input type="password" placeholder="Password" />
                    <button>Sign Up</button>
                </form>
            </div>
            <div class="form-container sign-in">
                <form action="/Rloyal/login" method="post">
                    <h1>Sign In</h1>
                    <p class="text-danger" style="color:red">${mess}</p>
                    <div class="social-icons">
                        <a href="#" class="icon"
                           ><i class="fa-brands fa-google-plus-g"></i
                            ></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"
                           ><i class="fa-brands fa-linkedin-in"></i
                            ></a>
                    </div>
                    <span>or use your email password</span>
                    <jsp:useBean id="userBean" class="Model.UserBean" scope="request" />
                    <input type="text" placeholder="username" name="user" 
                           value="<% 
                                    String username = (String)request.getAttribute("username");
                                    if (username != null && !username.isEmpty()) { 
                           %><jsp:getProperty name="userBean" property="username" /><% 
                                    } 
                           %>"/>
                    <input type="password" placeholder="password" name="password" 
                           value="<% 
                                    String password = (String)request.getAttribute("password");
                                    if (password != null && !password.isEmpty()) { 
                           %><jsp:getProperty name="userBean" property="password" /><% 
                                    } 
                           %>"/>
                    <span for="remember"> Remember me
                        <input type="checkbox" name="remember" id="remember" >
                        <a href="#">Forget Your Password?</a>
                        <button>Sign In</button>
                </form>
            </div>
            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>Welcome Back!</h1>
                        <p>Enter your personal details to use all of site features</p>
                        <button class="hidden" id="login">Sign In</button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <!-- De anh -->
                    </div>
                </div>
            </div>
        </div>

        <script src="script.js"></script>
    </body>
</html>
