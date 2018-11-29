package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2018/11/20 0020.
 */

public class Fruit {
    private  String name;
    private  int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Fruit(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }
}
