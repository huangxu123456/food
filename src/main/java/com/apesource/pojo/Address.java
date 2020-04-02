package com.apesource.pojo;

import java.io.Serializable;

public class Address implements Serializable{
    private  int addId;
    private String address;
    private int userId;
    private Users user;


    public Address(String address, int userId) {
        this.address = address;
        this.userId = userId;
    }

    public Address(int addId, String address, int userId, Users user) {
        this.addId = addId;
        this.address = address;
        this.userId = userId;
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addId=" + addId +
                ", address='" + address + '\'' +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }

    public Address() {
    }

    public Address(int addId, String address, int userId) {
        this.addId = addId;
        this.address = address;
        this.userId = userId;
    }

    public int getAddId() {
        return addId;
    }

    public void setAddId(int addId) {
        this.addId = addId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
