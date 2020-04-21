package com.designPattern.nineWeek;

public class Info extends OfficialDocument {
    private static Info instance = new Info();
    private Info(){
        this.type = "info";
    }
    public static Info getInstance(){
        return instance;
    }
    @Override
    void write() {
        System.out.println("这是信息公文模板");
    }
}
