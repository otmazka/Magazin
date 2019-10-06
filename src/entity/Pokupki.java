/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author User
 */
public class Pokupki implements Serializable {

    private Product product;
    private Buyer buyer;
    private int amount;//koli4estvo wtuk
    private int payment;//platez
    private Date takeOn;

    public Pokupki() {
    }

    public Pokupki(Product product, Buyer buyer, int amount, int payment, Date takeOn) {
        this.product = product;
        this.buyer = buyer;
        this.amount = amount;
        this.payment = payment;
        this.takeOn = takeOn;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setTakeOn(Date takeOn) {
        this.takeOn = takeOn;
    }

    public Product getProduct() {
        return product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public int getAmount() {
        return amount;
    }

    public int getPayment() {
        return payment;
    }

    public Date getTakeOn() {
        return takeOn;
    }

    @Override
    public String toString() {
        return "Pokupki{" + "product=" + product + ", buyer=" + buyer + ", amount=" + amount + ", payment=" + payment + ", takeOn=" + takeOn + '}';
    }

}
