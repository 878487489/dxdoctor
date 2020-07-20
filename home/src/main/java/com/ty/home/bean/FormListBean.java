package com.ty.home.bean;

public class FormListBean {
    private String title;
    private String imgurl;
    private String content;
    private String price;
    private int person;
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    public String getImgurl() {
        return imgurl;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPerson(int person) {
        this.person = person;
    }
    public int getPerson() {
        return person;
    }

}
