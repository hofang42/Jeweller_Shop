/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;
import java.sql.Timestamp;
/**
 *
 * @author tuank
 */
public class TokenForgetPassword {
    private int id, userID;
    private boolean isUsed;
    private String token;
    private Timestamp  expiryTime;

    public TokenForgetPassword() {
    }

    public TokenForgetPassword(int id, Timestamp expiryTime, int userID, boolean isUsed, String token) {
        this.id = id;
        this.userID = userID;
        this.isUsed = isUsed;
        this.token = token;
        this.expiryTime = expiryTime;
    }

    public TokenForgetPassword(int userID, Timestamp expiryTime, boolean isUsed, String token) {
        this.userID = userID;
        this.isUsed = isUsed;
        this.token = token;
        this.expiryTime = expiryTime;
    }
    
    public TokenForgetPassword(int userID, boolean isUsed, String token) {
        this.userID = userID;
        this.isUsed = isUsed;
        this.token = token;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Timestamp expiryTime) {
        this.expiryTime = expiryTime;
    }
    
    
}
