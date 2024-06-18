<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý Sản phẩm</title>
    </head>
    <body>
        <h1>Quản lý Sản phẩm</h1>

        <h2>Thêm Sản phẩm</h2>
        <form action="/Rloyal/admin" method="post">
            <label for="product_name">Tên sản phẩm:</label>
            <input type="text" id="product_name" name="product_name" required><br>

            <label for="product_category_id">Mã danh mục sản phẩm:</label>
            <input type="text" id="product_category_id" name="product_category_id" required><br>

            <label for="product_collection_id">Mã bộ sưu tập sản phẩm:</label>
            <input type="text" id="product_collection_id" name="product_collection_id" required><br>

            <label for="image_link">Link ảnh:</label>
            <input type="text" id="image_link" name="image_link" required><br>

            <input type="submit" name="addSubmit" value="Thêm Sản phẩm">
            <p>${mess}</p>
        </form>

        <h2>Xóa Sản phẩm</h2>
        <form action="/Rloyal/admin"" method="post">
            <label for="product_id_delete">Mã sản phẩm:</label>
            <input type="text" id="product_id_delete" name="product_id_delete" required><br>

            <input type="submit" name="delete_submit" value="Xóa Sản phẩm">
            <p>${mess1}</p>

        </form>

        <h2>Sửa Sản phẩm</h2>
        <form action="/Rloyal/admin"" method="post">
            <label for="product_id_update">Mã sản phẩm:</label>
            <input type="text" id="product_id_update" name="product_id_update" required><br>

            <label for="product_name_update">Tên sản phẩm mới:</label>
            <input type="text" id="product_name_update" name="product_name_update"><br>

            <label for="product_category_id_update">Mã danh mục sản phẩm mới:</label>
            <input type="text" id="product_category_id_update" name="product_category_id_update"><br>

            <label for="product_collection_id_update">Mã bộ sưu tập sản phẩm mới:</label>
            <input type="text" id="product_collection_id_update" name="product_collection_id_update"><br>

            <label for="image_link_update">Link ảnh mới:</label>
            <input type="text" id="image_link_update" name="image_link_update"><br>

            <input type="submit" name="update_submit" value="Sửa Sản phẩm">
            <p>${mess2}</p>

        </form>
    </body>
</html>
