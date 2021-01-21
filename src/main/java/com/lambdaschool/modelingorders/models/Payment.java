package com.lambdaschool.modelingorders.models;

import javax.persistence.*;

public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long paymentid;

    private String type;

    public Payment() {
    }

    public Payment(String type) {
        this.type = type;
    }

    public long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
