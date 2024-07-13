<%-- 
    Document   : editpassword
    Created on : Jul 12, 2024, 7:34:19 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
    <h1>PASSWORD</h1>
    <nav><a href="#">HOME</a> | <a href="#">MY ACCOUNT</a></nav>
    <h2>CHANGE PASSWORD</h2>
    <form>
        <label for="current-password">CURRENT PASSWORD *</label>
        <input type="password" id="current-password" required />

        <label for="new-password">NEW PASSWORD *</label>
        <input type="password" id="new-password" required />

        <label for="confirm-password">CONFIRM NEW PASSWORD *</label>
        <input type="password" id="confirm-password" required />

        <div class="buttons">
            <button type="button" class="cancel">CANCEL</button>
            <button type="submit" class="save">SAVE</button>
        </div>
    </form>
</body>