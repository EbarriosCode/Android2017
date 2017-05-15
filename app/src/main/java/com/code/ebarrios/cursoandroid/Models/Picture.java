package com.code.ebarrios.cursoandroid.Models;

/**
 * Created by Ebarrios on 12/05/2017.
 */

public class Picture {
    private String picture;
    private String userName;
    private String time;
    private String numeroLikes = "0";

    public Picture(String picture, String userName, String time, String numeroLikes) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.numeroLikes = numeroLikes;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(String numeroLikes) {
        this.numeroLikes = numeroLikes;
    }
}
