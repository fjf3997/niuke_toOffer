package com.fjf.os3;

public class Page {
    //页号
    private int id;
    //标志
    private boolean flag;
    //主存块号
    private int num;
    //在磁盘上的位置
    private int addr;

    public Page() {
    }

    public Page(int id, boolean flag, int num, int addr) {
        this.id = id;
        this.flag = flag;
        this.num = num;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", flag=" + flag +
                ", num=" + num +
                ", addr=" + addr +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAddr() {
        return addr;
    }

    public void setAddr(int addr) {
        this.addr = addr;
    }
}
