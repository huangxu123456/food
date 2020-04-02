package com.apesource.pojo;

public class Order1 {
    private int orderId;
    private int userId;
    private int mId;
    private int orderType;
    private String createDate;
    private int comId;
    private  Users users;
    private Menu menu;
    private Address address;
    private Comment comment;


    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Order1(int orderId, int userId, int mId, int orderType, String createDate, int comId, Users users, Menu menu, Address address, Comment comment) {
        this.orderId = orderId;
        this.userId = userId;
        this.mId = mId;
        this.orderType = orderType;
        this.createDate = createDate;
        this.comId = comId;
        this.users = users;
        this.menu = menu;
        this.address = address;
        this.comment = comment;
    }

    public Order1(int orderId, int userId, int mId, int orderType, String createDate, int comId, Users users, Menu menu, Address address) {
        this.orderId = orderId;
        this.userId = userId;
        this.mId = mId;
        this.orderType = orderType;
        this.createDate = createDate;
        this.comId = comId;
        this.users = users;
        this.menu = menu;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order1(int orderId, int userId, int mId, int orderType, String createDate, int comId, Users users, Menu menu) {
        this.orderId = orderId;
        this.userId = userId;
        this.mId = mId;
        this.orderType = orderType;
        this.createDate = createDate;
        this.comId = comId;
        this.users = users;
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Order1(int orderId, int userId, int mId, int orderType, String createDate, int comId, Users users) {
        this.orderId = orderId;
        this.userId = userId;
        this.mId = mId;
        this.orderType = orderType;
        this.createDate = createDate;
        this.comId = comId;
        this.users = users;

    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Order1{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", mId=" + mId +
                ", orderType=" + orderType +
                ", createDate='" + createDate + '\'' +
                ", comId=" + comId +
                ", users=" + users +
                ", menu=" + menu +
                ", address=" + address +
                '}';
    }

    public Order1(int orderId, int userId, int mId, String createDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.mId = mId;
        this.createDate = createDate;
    }

    public Order1() {
    }

    public Order1(int orderId, int userId, int mId, int orderType, String createDate, int comId) {


        this.orderId = orderId;
        this.userId = userId;
        this.mId = mId;
        this.orderType = orderType;
        this.createDate = createDate;
        this.comId = comId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }
}
