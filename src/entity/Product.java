/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Product implements Serializable {

    
    private String title;
    private String vid;
    private int price;
    private int quantity;
    private int count;

    public Product() {
    }

    public Product(String title, String author, int year, int quantity) {
        this.title = title;
        this.vid = vid;
        this.price = price;
        this.quantity = quantity;
        this.count = quantity;
    }

    public String getTitle() {
        return title;
    }

    public Product(String title, String vid, int price, int quantity, int count) {
        this.title = title;
        this.vid = vid;
        this.price = price;
        this.quantity = quantity;
        this.count = count;
    }

    public String getVid() {
        return vid;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCount() {
        return count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "Tovar{" + "title=" + title + ", vid=" + vid + ", price=" + price + ", quantity=" + quantity + ", count=" + count + '}';
    }
}
