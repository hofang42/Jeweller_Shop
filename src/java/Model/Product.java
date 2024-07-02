/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Product {
    public int product_id;
    public String product_name;
    public int product_category_id,
            product_collection_id;
    public String image;
    public Date created_at, modified_at, deleted_at;
    public int discount_id;
    public double original_price, sale_price;

    public Product(int product_id, String product_name, int product_category_id, int product_collection_id, String image) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_category_id = product_category_id;
        this.product_collection_id = product_collection_id;
        this.image = image;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_category_id() {
        return product_category_id;
    }

    public int getProduct_collection_id() {
        return product_collection_id;
    }

    public String getImage() {
        return image;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public double getOriginal_price() {
        return original_price;
    }

    public double getSale_price() {
        return sale_price;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", product_name=" + product_name + ", product_category_id=" + product_category_id + ", product_collection_id=" + product_collection_id + ", image=" + image + ", created_at=" + created_at + ", modified_at=" + modified_at + ", deleted_at=" + deleted_at + ", discount_id=" + discount_id + ", original_price=" + original_price + ", sale_price=" + sale_price + '}';
    }
    
    
    
    
    
}
