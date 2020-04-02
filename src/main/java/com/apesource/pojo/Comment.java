package com.apesource.pojo;

import java.io.Serializable;

public class Comment implements Serializable {
    private int comId;
    private int comStar;
    private String comComment;


    @Override
    public String toString() {
        return "Comment{" +
                "comId=" + comId +
                ", comStar=" + comStar +
                ", comComment='" + comComment + '\'' +
                '}';
    }

    public Comment(int comStar, String comComment) {
        this.comStar = comStar;
        this.comComment = comComment;
    }

    public Comment() {
    }

    public Comment(int comId, int comStar, String comComment) {
        this.comId = comId;
        this.comStar = comStar;
        this.comComment = comComment;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getComStar() {
        return comStar;
    }

    public void setComStar(int comStar) {
        this.comStar = comStar;
    }

    public String getComComment() {
        return comComment;
    }

    public void setComComment(String comComment) {
        this.comComment = comComment;
    }
}
