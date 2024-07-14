/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import JDBC.DAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Cart {

    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    private CartItem getItemById(int id) {
        for (CartItem i : items) {
            if (i.getProduct().getProduct_id() == id) {
                return i;
            }
        }
        return null;
    }

    public void addItem(CartItem item) {
        if (getItemById(item.getProduct().getProduct_id()) == null) {
            items.add(item);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (CartItem i : items) {
            t += (i.getQuantity() * i.getPrice());
        }
        return t;
    }

    private ProductDetail getProductById(int id, List<ProductDetail> list) {
        for (ProductDetail p : list) {
            if (p.getProduct_id() == id) {
                return p;
            }
        }
        return null;
    }

    private ProductImg getImgById(int id, List<ProductImg> list) {
        for (ProductImg pm : list) {
            if (pm.getProduct_id() == id) {
                return pm;
            }
        }
        return null;
    }

    public Cart(String txt, List<ProductDetail> list, List<ProductImg> img_list) {
        items = new ArrayList<>();
        DAO d = new DAO();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("\\.");
                for (String i : s) {
                    String[] n = i.split(":");
                    int id = Integer.parseInt(n[0]);
                    int size = Integer.parseInt(n[1]);
                    ProductDetail p = getProductById(id, list);
                    ProductImg pm = getImgById(id, img_list);
                    int oPrice = p.getOriginal_price();
                    CartItem t = new CartItem(pm, p, size, oPrice);
                    t.setQuantity(1);
                    addItem(t);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cart(int id, List<ProductDetail> list, List<ProductImg> img_list, int quantity) {
        items = new ArrayList<>();
        CartItem c = null;
        ProductDetail p = getProductById(id, list);
        ProductImg pm = getImgById(id, img_list);
        c = new CartItem(pm, p, quantity);
        addItem(c);
    }
    
    public static void main(String[] args) {
        DAO d = new DAO();
        Cart cart = new Cart("1042:0.1069:0.1069:0.1069:0.1069:0.1069:0.1069:0.1069:0.1069:0.1069:0.1069:0.1069:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:53.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0.1064:0",
        d.getAllProductDetails(), d.getAllProduct_img());
        for (CartItem c : cart.getItems()) {
            System.out.println(c);
        }
    }
}
