package com.designPattern.nineWeek;

public class Notice extends OfficialDocument {
    private static Notice instance = new Notice();//创建Report的一个对象
    private Notice() {
        type = "notice";
    }
    public static Notice getInstance(){
        return instance;
    }
    @Override
    void write() {
        System.out.println("这是通知公文模板");
    }
}
