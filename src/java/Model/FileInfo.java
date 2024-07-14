package Model;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class FileInfo {

    String name;
    long lastModified;

    public FileInfo(String name, long lastModified) {
        this.name = name;
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public long getLastModified() {
        return lastModified;
    }
}
