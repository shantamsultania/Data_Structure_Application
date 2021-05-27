package com.example.datastructureapplication;

public class Model {
    String title, qurl;

    Model() {

    }

    public Model(String title, String qurl) {
        this.title = title;
        this.qurl = qurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQurl() {
        return qurl;
    }

    public void setQurl(String qurl) {
        this.qurl = qurl;
    }
}
