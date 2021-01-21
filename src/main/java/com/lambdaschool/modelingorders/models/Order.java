package com.lambdaschool.modelingorders.models;

import javax.persistence.*;

public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long ordnum;

    private double advanceamount;
    private double ordamount;
    private String orderdescription;

    public Order() {}

    public Order(double advanceamount, double ordamount, String orderdescription) {
        this.advanceamount = advanceamount;
        this.ordamount = ordamount;
        this.orderdescription = orderdescription;
    }

    public long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(long ordnum) {
        this.ordnum = ordnum;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }
}
