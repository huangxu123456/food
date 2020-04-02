package com.apesource.pojo;

import java.io.Serializable;

public class Menu implements Serializable {
    private int mId;
    private String mMname;
    private double mCost;
    private int mPoint;

    @Override
    public String toString() {
        return "Menu{" +
                "mId=" + mId +
                ", mMname='" + mMname + '\'' +
                ", mCost=" + mCost +
                ", mPoint=" + mPoint +
                '}';
    }

    public Menu() {
    }

    public Menu(int mId, String mMname, double mCost, int mPoint) {
        this.mId = mId;
        this.mMname = mMname;
        this.mCost = mCost;
        this.mPoint = mPoint;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmMname() {
        return mMname;
    }

    public void setmMname(String mMname) {
        this.mMname = mMname;
    }

    public double getmCost() {
        return mCost;
    }

    public void setmCost(double mCost) {
        this.mCost = mCost;
    }

    public int getmPoint() {
        return mPoint;
    }

    public void setmPoint(int mPoint) {
        this.mPoint = mPoint;
    }
}
