package com.lambdaschool.modelingorders.models;

import javax.persistence.*;

public class Agent {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long agentcode;

    private String name;

    private Double commission;

    private String country;

    private String phone;


    public Agent(String name, Double commission, String country, String phone, String workingarea) {
        this.name = name;
        this.commission = commission;
        this.country = country;
        this.phone = phone;
//        this.workingarea = workingarea;
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

//    public String getWorkingarea() {
//        return workingarea;
//    }
//
//    public void setWorkingarea(String workingarea) {
//        this.workingarea = workingarea;
//    }
}
