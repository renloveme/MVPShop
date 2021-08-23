package com.example.mvpshop.bean;

public class MyPicture {

    private String name;
    private int imageId;

    public MyPicture(String name,int imageId){
        this.imageId=imageId;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
