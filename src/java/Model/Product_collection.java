/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class Product_collection {
    public int product_collection_id;
    public String product_collection_name;
    public int product_category_id;
    public String image;

    public Product_collection(int product_collection_id, String product_collection_name, int product_category_id, String image) {
        this.product_collection_id = product_collection_id;
        this.product_collection_name = product_collection_name;
        this.product_category_id = product_category_id;
        this.image = image;
    }

    public int getProduct_collection_id() {
        return product_collection_id;
    }

    public String getProduct_collection_name() {
        return product_collection_name;
    }

    public int getProduct_category_id() {
        return product_category_id;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Product_collection{" + "product_collection_id=" + product_collection_id + ", product_collection_name=" + product_collection_name + ", product_category_id=" + product_category_id + ", image=" + image + '}';
    }
    
    
}
