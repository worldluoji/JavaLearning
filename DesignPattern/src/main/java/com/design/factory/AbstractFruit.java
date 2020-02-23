package com.design.factory;

public abstract class AbstractFruit implements Fruit {
    private String name;
    private String quality;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void show() {
        System.out.println("这是" + name + ", 质量：" + quality + ", 出产地" + address);
    }
}
