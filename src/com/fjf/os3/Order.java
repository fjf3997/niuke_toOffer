package com.fjf.os3;

public class Order {
    //操作
    private String operate;
    //页号
    private int id;
    //单元号
    private int unit;

    public Order() {
    }

    public Order(String operate, int id, int unit) {
        this.operate = operate;
        this.id = id;
        this.unit = unit;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
