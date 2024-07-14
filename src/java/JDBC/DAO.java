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
import Model.TokenForgetPassword;
import Model.User;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        String sql = "SELECT * FROM Product ";
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
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
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
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13),
                        rs.getString(14),
                        rs.getString(15));
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
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13),
                        rs.getString(14),
                        rs.getString(15))
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pList;
    }

    public User getUserbyEmail(String user_email) {
        String sql = "SELECT * from [User_web] where user_email = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user_email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public String getFormatDate(LocalDateTime myDateObj) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public boolean insertTokenForget(TokenForgetPassword tokenForget) {
        String sql = "INSERT INTO [dbo].[tokenForgetPassword]\n"
                + "           ([token]\n"
                + //"           ,[expiryTime]\n" +                
                "           ,[isUsed]\n"
                + "           ,[userId])\n"
                + "     VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tokenForget.getToken());
//            ps.setTimestamp(2, tokenForget.getExpiryTime());
            ps.setBoolean(2, tokenForget.isIsUsed());
            ps.setInt(3, tokenForget.getUserID());

            return ps.executeUpdate() > 0;
            // neu co ban ghi moi thi no se thuc hien

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public TokenForgetPassword getTokenPassword(String token) {
        String sql = "Select * from [tokenForgetPassword] where token = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, token);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new TokenForgetPassword(
//                        rs.getInt("id"),
//                        rs.getTimestamp("expiryTime"),
                        rs.getInt("userId"),
                        rs.getBoolean("isUsed"),
                        rs.getString("token")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public User getUserById(int userId) {
        String sql = "SELECT * from [User_web] where user_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void updatePassword(String email, String password) {
        String sql = "UPDATE [dbo].[user_web] SET [password] = ? WHERE [user_email] = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, password);
            st.setString(2, email);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateStatus(TokenForgetPassword token) {
        System.out.println("token = "+token);
        String sql = "UPDATE [dbo].[tokenForgetPassword]\n"
                + "   SET [isUsed] = ?\n"
                + " WHERE token = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setBoolean(1, token.isIsUsed());
            st.setString(2, token.getToken());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        DAO d = new DAO();
        d.updatePassword("tuankhai2608@gmail.com","yeutrang1");
        System.out.println(d.getUserById(3));
    }
}
