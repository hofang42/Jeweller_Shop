/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DecimalFormat;

/**
 *
 * @author LENOVO
 */
public class PaymentInfo {
    private String product_name;
    private int product_id, amount;
    private String status;  
    private String price;

    public PaymentInfo(String product_name, int product_id, int amount, String status) {
        this.product_name = product_name;
        this.product_id = product_id;
        this.amount = amount;
        this.status = status;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
          DecimalFormat formatter = new DecimalFormat("#,###");
          String pric = formatter.format(amount);
          return pric;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" + "product_name=" + product_name + ", product_id=" + product_id + ", amount=" + amount + ", status=" + status + ", price=" + price + '}';
    }
    
    
    
    
}
