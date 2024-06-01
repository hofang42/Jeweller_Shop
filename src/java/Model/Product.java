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
    public Date created_at, modified_at, deleted_at;
    public int discount_id;
    public double original_price, sale_price;
    
    public Product(int product_id, String product_name, int product_category_id, int product_collection_id, Date created_at, Date modified_at, Date deleted_at, int discount_id, double original_price, double sale_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_category_id = product_category_id;
        this.product_collection_id = product_collection_id;
        this.created_at = created_at;
        this.modified_at = modified_at;
        this.deleted_at = deleted_at;
        this.discount_id = discount_id;
        this.original_price = original_price;
        this.sale_price = sale_price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(int product_category_id) {
        this.product_category_id = product_category_id;
    }

    public int getProduct_collection_id() {
        return product_collection_id;
    }

    public void setProduct_collection_id(int product_collection_id) {
        this.product_collection_id = product_collection_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getModified_at() {
        return modified_at;
    }

    public void setModified_at(Date modified_at) {
        this.modified_at = modified_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public double getSale_price() {
        return sale_price;
    }

    public void setSale_price(double sale_price) {
        this.sale_price = sale_price;
    }
    
    
}
