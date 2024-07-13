/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Receipt {
   private int id, user_id;
   private String full_name, email, address, city, phone_number, state;
   private int zipcode, amount;
   private String status;
   private Date created_at;
   private String user_google_id;

    public Receipt(int id, int user_id, String full_name, String email, String address, String city, String phone_number, String state, int zipcode, int amount, String status, Date created_at, String user_google_id) {
        this.id = id;
        this.user_id = user_id;
        this.full_name = full_name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.phone_number = phone_number;
        this.state = state;
        this.zipcode = zipcode;
        this.amount = amount;
        this.status = status;
        this.created_at = created_at;
        this.user_google_id = user_google_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUser_google_id() {
        return user_google_id;
    }

    public void setUser_google_id(String user_google_id) {
        this.user_google_id = user_google_id;
    }

    @Override
    public String toString() {
        return "Receipt{" + "id=" + id + ", user_id=" + user_id + ", full_name=" + full_name + ", email=" + email + ", address=" + address + ", city=" + city + ", phone_number=" + phone_number + ", state=" + state + ", zipcode=" + zipcode + ", amount=" + amount + ", status=" + status + ", created_at=" + created_at + ", user_google_id=" + user_google_id + '}';
    }

  
}
