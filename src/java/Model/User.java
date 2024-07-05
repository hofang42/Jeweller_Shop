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
public class User {
    public int user_id;
    public String user_name, user_phone, user_email, password, user_firstname, user_lastname, user_fullname;
    public int isAdmin;
    public Date created_at;

    public User(int user_id, String user_name, String user_phone, String user_email, String password, String user_firstname, String user_lastname, String user_fullname, int isAdmin, Date created_at) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.password = password;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_fullname = user_fullname;
        this.isAdmin = isAdmin;
        this.created_at = created_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_name=" + user_name + ", user_phone=" + user_phone + ", user_email=" + user_email + ", password=" + password + ", user_firstname=" + user_firstname + ", user_lastname=" + user_lastname + ", user_fullname=" + user_fullname + ", isAdmin=" + isAdmin + ", created_at=" + created_at + '}';
    }

    
}
