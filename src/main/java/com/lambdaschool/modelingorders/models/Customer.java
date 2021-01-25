package com.lambdaschool.modelingorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long custcode;

    private String custcity;
    private String custcountry;
    private String custname;
    private String workingarea;
    private String grade;

    private double openingamt;
    @Transient
    public boolean hasValueForOpeningAmt = false;

    private double outstandingamt;
    @Transient
    public boolean hasValueForOutstandingAmt = false;

    private double paymentamt;
    @Transient
    public boolean hasValueForPaymentAmt = false;

    private String phone;

    private double receiveamt;
    @Transient
    public boolean hasValueReceiveAmt = false;

//    empty public Customer(){} throws an error

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnoreProperties(value = "customers", allowSetters = true )
    private Agent agent;

    @OneToMany(mappedBy = "customer",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties(value = "customer", allowSetters = true)
    private List<Order> orders = new ArrayList<>();

    public Customer(){}


    public Customer(String custname,
                    String custcity,
                    String workingarea,
                    String custcountry,
                    String grade,
                    double openingamt,
                    double receiveamt,
                    double paymentamt,
                    double outstandingamt,
                    String phone,
                    Agent agent)
    {
        this.custname = custname;
        this.custcity = custcity;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agent = agent;
    }

    public long getCustcode() {
        return custcode;
    }

    public void setCustcode(long custcode) {
        this.custcode = custcode;
    }

    public String getCustcity() {
        return custcity;
    }

    public void setCustcity(String custcity) {
        this.custcity = custcity;
    }

    public String getCustcountry() {
        return custcountry;
    }

    public void setCustcountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningamt() {
        hasValueForOpeningAmt = true;
        return openingamt;
    }

    public void setOpeningamt(double openingamt) {
        this.openingamt = openingamt;
    }

    public double getOutstandingamt() {
        hasValueForOutstandingAmt = true;
        return outstandingamt;
    }

    public void setOutstandingamt(double outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public double getPaymentamt() {
        hasValueForPaymentAmt = true;
        return paymentamt;
    }

    public void setPaymentamt(double paymentamt) {
        this.paymentamt = paymentamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getReceiveamt() {
        hasValueReceiveAmt = true;
        return receiveamt;
    }

    public void setReceiveamt(double receiveamt) {
        this.receiveamt = receiveamt;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
