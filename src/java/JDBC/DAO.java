/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;

import Model.Product;
import Model.ProductDetail;
import Model.ProductImg;
import Model.Product_Category;
import Model.Product_collection;
import Model.Receipt;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DAO extends DBContext {

    public List<Product_Category> getAllCategoryNoParents() {
        List<Product_Category> list = new ArrayList<>();
        String sql = "SELECT * FROM product_category where product_category_parent_id is null";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product_Category(rs.getInt("product_category_id"), rs.getInt("product_category_parent_id"), rs.getString("product_category_name")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return list;
    }

    public List<Product_Category> getAllCategoryHaveParentsByName(int id) {
        List<Product_Category> list = new ArrayList<>();
        String sql = "SELECT * FROM product_category where product_category_parent_id=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product_Category(rs.getInt("product_category_id"), rs.getInt("product_category_parent_id"), rs.getString("product_category_name")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return list;
    }

    public List<Product_collection> getAllCollectionByCategory(int id) {
        List<Product_collection> cList = new ArrayList<>();
        String sql = "SELECT * FROM Product_collection where product_category_id=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product_collection(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }

    public List<Product> getAllProduct() {
        List<Product> cList = new ArrayList<>();
        String sql = "SELECT TOP 8 * FROM Product ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString("image")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }

    public User getUser(String user, String pass) {
        User u = null;
        String sql = "SELECT * FROM USER_WEB WHERE USER_NAME=? AND PASSWORD=? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                u = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(10),
                        rs.getInt(6),
                        rs.getDate(9));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return u;
    }

    public boolean Product_Insert(String name, int cId, int pId, String img) {
        PreparedStatement stmt = null;
        int c = 0;
        try {
            // Sử dụng câu lệnh SQL với OUTPUT INSERTED.id
            String sql = "INSERT INTO Product (product_name, product_category_id, product_collection_id, image) OUTPUT INSERTED.product_id VALUES(?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, cId);
            stmt.setInt(3, pId);
            stmt.setString(4, img);

            // Sử dụng executeQuery để lấy ResultSet trả về
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                c++;
            }
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean Product_Update(int prId, String name, int cId, int pId, String img) {
        PreparedStatement stmt = null;
        try {
            // Sử dụng câu lệnh SQL với OUTPUT INSERTED.id
            String sql = "UPDATE PRODUCT SET Product_name=?, product_category_id=?, product_collection_id=?, image=? where product_id=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, cId);
            stmt.setInt(3, pId);
            stmt.setString(4, img);
            stmt.setInt(5, prId);

            int rowUpdate = stmt.executeUpdate();
            return rowUpdate > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean Product_Delete(int id) {
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM Product WHERE product_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ProductDetail getProductDetailById(int id) {
        ProductDetail p = null;
        String sql = "SELECT * FROM PRODUCT_INFO WHERE product_id=? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new ProductDetail(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return p;
    }

    public ProductImg getOneProduct_img(int product_info_id) {
        ProductImg link = null;
        String sql = "SELECT TOP 1 * FROM PRODUCT_IMG WHERE PRODUCT_ID=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, product_info_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                link = new ProductImg(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return link;
    }

    public List<String> getProduct_img(int product_info_id) {
        List<String> link = new ArrayList<>();
        String sql = "SELECT img_link FROM PRODUCT_IMG WHERE PRODUCT_ID=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, product_info_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                link.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return link;
    }

    public List<ProductImg> getAllProduct_img() {
        List<ProductImg> list = new ArrayList<>();
        String sql = "SELECT  * from product_img ";
        ProductImg pm = null;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new ProductImg(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ProductDetail> getAllProductDetails() {
        List<ProductDetail> pList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT_INFO";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pList.add(new ProductDetail(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getInt(15))
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pList;
    }

    public boolean Payment_insert(int user_id,
            String full_name, String email,
            String address, String city,
            String phone_number, String state,
            int zip_code, int amount,
            String status) {
        PreparedStatement stmt = null;
        int c = 0;
        try {
            // Sử dụng câu lệnh SQL với OUTPUT INSERTED.id
            String sql = "insert into payment_details (user_id, full_name, email, address, city, phone_number, state, zipcode, amount, status) values(?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, user_id);
            stmt.setString(2, full_name);
            stmt.setString(3, email);
            stmt.setString(4, address);
            stmt.setString(5, city);
            stmt.setString(6, phone_number);
            stmt.setString(7, state);
            stmt.setInt(8, zip_code);
            stmt.setInt(9, amount);
            stmt.setString(10, status);

            // Sử dụng executeQuery để lấy ResultSet trả về
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                c++;
            }
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean Payment_insert_google(String google_id,
            String full_name, String email,
            String address, String city,
            String phone_number, String state,
            int zip_code, int amount,
            String status) {
        PreparedStatement stmt = null;
        int c = 0;
        try {
            // Sử dụng câu lệnh SQL với OUTPUT INSERTED.id
            String sql = "insert into payment_details (user_google_id, full_name, email, address, city, phone_number, state, zipcode, amount, status) values(?,?,?,?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, google_id);
            stmt.setString(2, full_name);
            stmt.setString(3, email);
            stmt.setString(4, address);
            stmt.setString(5, city);
            stmt.setString(6, phone_number);
            stmt.setString(7, state);
            stmt.setInt(8, zip_code);
            stmt.setInt(9, amount);
            stmt.setString(10, status);

            // Sử dụng executeQuery để lấy ResultSet trả về
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                c++;
            }
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Receipt getMaxPaymentId() {
        Receipt rec = null;
        String sql = "SELECT TOP 1 * FROM PAYMENT_DETAILS ORDER BY ID DESC";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                rec = new Receipt(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getDate(12));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rec;
    }

    public boolean Order_insert(int product_id, int quantity, int payment_id) {
        PreparedStatement stmt = null;
        int c = 0;
        try {
            // Sử dụng câu lệnh SQL với OUTPUT INSERTED.id
            String sql = "insert into order_items (product_id, quantity, payment_id) values(?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, product_id);
            stmt.setInt(2, quantity);
            stmt.setInt(3, payment_id);

            // Sử dụng executeQuery để lấy ResultSet trả về
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                c++;
            }
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean Google_insert(String user_id, String fullname, String firstname, String lastname, String email) {
        PreparedStatement stmt = null;
        int c = 0;
        try {
            // Sử dụng câu lệnh SQL với OUTPUT INSERTED.id
            String sql = "INSERT INTO user_google_login (google_id, user_fullname, user_firstname, user_lastname, user_email) VALUES(?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user_id);
            stmt.setString(2, fullname);
            stmt.setString(3, firstname);
            stmt.setString(4, lastname);
            stmt.setString(5, email);

            // Sử dụng executeQuery để lấy ResultSet trả về
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                c++;
            }
            return c > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean Update_status(String status, int id) {
        PreparedStatement stmt = null;
        try {
            // Sử dụng câu lệnh SQL với OUTPUT INSERTED.id
            String sql = "UPDATE PAYMENT_DETAILS SET STATUS=? WHERE ID=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setInt(2, id);
            int rowUpdate = stmt.executeUpdate();
            return rowUpdate > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> getAllProductByCategoryId(int cId) {
        List<Product> cList = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE product_category_id=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString("image")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }

    public List<Product> getAllProductByCollectionId(int cId) {
        List<Product> cList = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE product_collection_id=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString("image")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }

    public List<Product> getAllProductByDescPrice() {
        List<Product> cList = new ArrayList<>();
        String sql = "SELECT p.* \n"
                + "FROM PRODUCT p \n"
                + "LEFT JOIN Product_Info i ON p.product_id = i.product_id \n"
                + "ORDER BY i.original_price DESC;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString("image")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }

    public List<Product> getAllProductByIncPrice() {
        List<Product> cList = new ArrayList<>();
        String sql = "SELECT p.* \n"
                + "FROM PRODUCT p \n"
                + "LEFT JOIN Product_Info i ON p.product_id = i.product_id \n"
                + "ORDER BY i.original_price ASC;";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString("image")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }

    public List<Product> getBestSeller() {
        List<Product> cList = new ArrayList<>();
        String sql = "SELECT * \n"
                + "FROM PRODUCT P \n"
                + "LEFT JOIN (\n"
                + "    SELECT PRODUCT_ID, COUNT(QUANTITY) AS QUANTITY\n"
                + "    FROM order_items \n"
                + "    GROUP BY PRODUCT_ID\n"
                + ") O ON P.product_id = O.PRODUCT_ID ORDER BY O.QUANTITY DESC";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString("image")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }

    public List<Product> getNewArrivalList() {
        List<Product> cList = new ArrayList<>();
        String sql = "SELECT * FROM Product ORDER BY PRODUCT_ID DESC";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString("image")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }

    public List<Product> getNext3Product(int cId) {
        List<Product> cList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT ORDER BY PRODUCT_ID OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString("image")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }
    
    public List<Product> getProductByCategoryName(String cId) {
        List<Product> cList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT WHERE product_category_id = (SELECT product_category_id FROM PRODUCT_CATEGORY WHERE PRODUCT_CATEGORY_NAME = ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cList.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString("image")));
            }
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return cList;
    }
    public static void main(String[] args) {
        DAO d = new DAO();
        d.Payment_insert_google("2", "Phan Le Thanh Hoang", "ringhost@gmail.com", "abc", "Da Nang", "0836112233","Hoa Hai" ,12, 1000, "Success");
    }
}
