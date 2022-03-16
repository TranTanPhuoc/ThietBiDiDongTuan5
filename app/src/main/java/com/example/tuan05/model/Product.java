package com.example.tuan05.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String about;
    private int img;
    private String price;
    private  String  type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product(String name, String about, int img, String price, String type) {
        this.name = name;
        this.about = about;
        this.img = img;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", img=" + img +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
