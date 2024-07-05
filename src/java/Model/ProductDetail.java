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
public class ProductDetail {

    private int product_info_id;
    private String product_name, material, gemstone, size, resizable, pendant, diamond, offactive_family,
            colour;
    private int product_id;
    private String product_full_desc, product_small_desc;
    private int original_price, sale_price;
    String price;

    public ProductDetail(int product_info_id, String product_name, String material, String gemstone, String size, String resizable, String pendant, String diamond, String offactive_family, String colour, int product_id, String product_full_desc, String product_small_desc, int original_price, int sale_price) {
        this.product_info_id = product_info_id;
        this.product_name = product_name;
        this.material = material;
        this.gemstone = gemstone;
        this.size = size;
        this.resizable = resizable;
        this.pendant = pendant;
        this.diamond = diamond;
        this.offactive_family = offactive_family;
        this.colour = colour;
        this.product_id = product_id;
        this.product_full_desc = product_full_desc;
        this.product_small_desc = product_small_desc;
        this.original_price = original_price;
        this.sale_price = sale_price;
    }

    public int getProduct_info_id() {
        return product_info_id;
    }

    public void setProduct_info_id(int product_info_id) {
        this.product_info_id = product_info_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getGemstone() {
        return gemstone;
    }

    public void setGemstone(String gemstone) {
        this.gemstone = gemstone;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getResizable() {
        return resizable;
    }

    public void setResizable(String resizable) {
        this.resizable = resizable;
    }

    public String getPendant() {
        return pendant;
    }

    public void setPendant(String pendant) {
        this.pendant = pendant;
    }

    public String getDiamond() {
        return diamond;
    }

    public void setDiamond(String diamond) {
        this.diamond = diamond;
    }

    public String getOffactive_family() {
        return offactive_family;
    }

    public void setOffactive_family(String offactive_family) {
        this.offactive_family = offactive_family;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(int original_price) {
        this.original_price = original_price;
    }

    public int getSale_price() {
        return sale_price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_full_desc() {
        return product_full_desc;
    }

    public void setProduct_full_desc(String product_full_desc) {
        this.product_full_desc = product_full_desc;
    }

    public String getProduct_small_desc() {
        return product_small_desc;
    }

    public void setProduct_small_desc(String product_small_desc) {
        this.product_small_desc = product_small_desc;
    }

    public String getPrice() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        String pric = formatter.format(original_price);
        return  pric;
    }

    @Override
    public String toString() {
        return "ProductDetail{" + "product_info_id=" + product_info_id + ", product_name=" + product_name + ", material=" + material + ", gemstone=" + gemstone + ", size=" + size + ", resizable=" + resizable + ", pendant=" + pendant + ", diamond=" + diamond + ", offactive_family=" + offactive_family + ", colour=" + colour + ", original_price=" + original_price + ", sale_price=" + sale_price + ", product_id=" + product_id + ", product_full_desc=" + product_full_desc + ", product_small_desc=" + product_small_desc + '}';
    }

}
