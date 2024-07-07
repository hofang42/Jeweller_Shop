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
        <title>RLoyal Login Page</title>
        <script>document.addEventListener('DOMContentLoaded', () => {
                const container = document.getElementById('container');
                const registerBtn = document.getElementById('register');
                const loginBtn = document.getElementById('login');

                registerBtn.addEventListener('click', () => {
                    container.classList.add("active");
                });

                loginBtn.addEventListener('click', () => {
                    container.classList.remove("active");
                });
            });</script>
    </head>

    <body>
        <%@include file="/Home/header.jsp"%>
        <div class="container" id="container">
            <div class="form-container sign-up">
                <form>
                    <h1>Create Account</h1>
                    <div class="social-icons">
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:9999/RloyalPRJ/LoginGoogle&response_type=code&client_id=587689264806-vbp5uaalgehr3tthq93ofknk3bq0j0c0.apps.googleusercontent.com&approval_prompt=force" class="icon"
                           ><i class="fa-brands fa-google-plus-g"></i
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
                <form action="/RloyalPRJ/login" method="post">
                    <h1>Sign In</h1>
                    <p class="text-danger" style="color:red">${mess}</p>
                    <div class="social-icons">
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:9999/RloyalPRJ/LoginGoogle&response_type=code&client_id=587689264806-vbp5uaalgehr3tthq93ofknk3bq0j0c0.apps.googleusercontent.com&approval_prompt=force" class="icon"
                           ><i class="fa-brands fa-google-plus-g"></i
                            ></a>
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:9999/RloyalPRJ/LoginGoogle&response_type=code&client_id=587689264806-vbp5uaalgehr3tthq93ofknk3bq0j0c0.apps.googleusercontent.com&approval_prompt=force" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:9999/RloyalPRJ/LoginGoogle&response_type=code&client_id=587689264806-vbp5uaalgehr3tthq93ofknk3bq0j0c0.apps.googleusercontent.com&approval_prompt=force" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:9999/RloyalPRJ/LoginGoogle&response_type=code&client_id=587689264806-vbp5uaalgehr3tthq93ofknk3bq0j0c0.apps.googleusercontent.com&approval_prompt=force" class="icon"
                           ><i class="fa-brands fa-linkedin-in"></i
                            ></a>
                    </div>
                    <span>or use your email password</span>
                    <input type="text" placeholder="username" name="user" 
                           value="${username}"/>
                    <input  type="password" placeholder="password" name="password" 
                            value="${pass}"/>
                    <div class="remember-box">
                        <span  for="remember"/> <p>Remember me</p>
                        </span>
                        <div class="checkbox-tick"><input type="checkbox" name="remember" id="remember" /></div>
                    </div>
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
                        <h1>Hello, Friend!</h1>
                        <p>Register with your personal details to use all of site features</p>
                        <button class="hidden" id="register">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>   
    </body>
</html>
