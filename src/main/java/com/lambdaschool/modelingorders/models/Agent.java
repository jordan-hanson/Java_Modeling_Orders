package com.lambdaschool.modelingorders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Agent {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    private String name;

    private Double commission;

    private String country;

    private String phone;

    private String workingarea;

    @OneToMany(mappedBy = "agent",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<Customer> customers = new ArrayList<>();

    public Agent(){}

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Agent(String name, String country, Double commission, String phone, String workingarea) {
        this.name = name;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
        this.workingarea = workingarea;
    }

    public long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(long agentcode) {
        this.agentcode = agentcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }
}
