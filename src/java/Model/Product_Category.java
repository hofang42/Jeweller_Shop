/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class Product_Category {
    public int product_category_id;
    public int product_category_parent_id;
    public String product_category_name;

    public Product_Category(int product_category_id, int product_category_parent_id, String product_category_name) {
        this.product_category_id = product_category_id;
        this.product_category_parent_id = product_category_parent_id;
        this.product_category_name = product_category_name;
    }

    public int getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(int product_category_id) {
        this.product_category_id = product_category_id;
    }

    public int getProduct_category_parent_id() {
        return product_category_parent_id;
    }

    public void setProduct_category_parent_id(int product_category_parent_id) {
        this.product_category_parent_id = product_category_parent_id;
    }

    public String getProduct_category_name() {
        return product_category_name;
    }

    public void setProduct_category_name(String product_category_name) {
        this.product_category_name = product_category_name;
    }
    
    
}
