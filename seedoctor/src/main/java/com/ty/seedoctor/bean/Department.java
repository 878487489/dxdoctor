package com.ty.seedoctor.bean;

public class Department {
    private int deptartmentImg;
    private String departName;

    public Department(int deptartmentImg, String departName) {
        this.deptartmentImg = deptartmentImg;
        this.departName = departName;
    }

    public int getDeptartmentImg() {
        return deptartmentImg;
    }

    public void setDeptartmentImg(int deptartmentImg) {
        this.deptartmentImg = deptartmentImg;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}
