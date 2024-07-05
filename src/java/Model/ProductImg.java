/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class ProductImg {
    private int img_id;
    private String img_link;
    private int product_id;

    public ProductImg(int img_id, String img_link, int product_id) {
        this.img_id = img_id;
        this.img_link = img_link;
        this.product_id = product_id;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "ProductImg{" + "img_id=" + img_id + ", img_link=" + img_link + ", product_id=" + product_id + '}';
    }
    
    
}
