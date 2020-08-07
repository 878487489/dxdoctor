package com.ty.find.bean;

public class DrugsTtem {
    private int img;
    private String title;
    private String  subtitle;

    public DrugsTtem(int img, String title, String subtitle) {
        this.img = img;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
