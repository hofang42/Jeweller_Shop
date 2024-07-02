/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class CartItem {
    private ProductImg img_link;
    private ProductDetail product;
    private int size;
    private int quantity;
    private double price;

    public CartItem(ProductImg img_link, ProductDetail product, int quantity) {
        this.img_link = img_link;
        this.product = product;
        this.quantity = quantity;
    }

    

    public CartItem(ProductImg img_link, ProductDetail product, int size, double price) {
        this.img_link = img_link;
        this.product = product;
        this.size = size;
        this.price = price;
    }
    
  
 
    
    public ProductImg getImg_link() {
        return img_link;
    }

    public void setImg_link(ProductImg img_link) {
        this.img_link = img_link;
    }

    public ProductDetail getProduct() {
        return product;
    }

    public void setProduct(ProductDetail product) {
        this.product = product;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItem{" + "img_link=" + img_link + ", product=" + product + ", size=" + size + ", quantity=" + quantity + ", price=" + price + '}';
    }

    
}
