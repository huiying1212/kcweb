package com.xxxx.entity;

import java.awt.*;

public class supporter {
    private String account;
    private String password;

    private java.awt.Image portrait;

    public Image getPortrait() {
        return portrait;
    }

    public void setPortrait(Image portrait) {
        this.portrait = portrait;
    }

    private String ppath;

    public String getPpath() {
        return ppath;
    }

    public void setPpath(String ppath) {
        this.ppath = ppath;
    }

    private Integer accumulation;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    public Image getPortrait() {
//        return portrait;
//    }
//
//    public void setPortrait(Image portrait) {
//        this.portrait = portrait;
//    }

    public Integer getAccumulation() {
        return accumulation;
    }

    public void setAccumulation(Integer accumulation) {
        this.accumulation = accumulation;
    }

}
