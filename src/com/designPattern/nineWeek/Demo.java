package com.designPattern.nineWeek;

public class Demo {
    public static void main(String[] args) {
        DocumentFactory documentFactory = new DocumentFactory();
        OfficialDocument info = documentFactory.getDocument("info");
        info.write();
        OfficialDocument notice = documentFactory.getDocument("notice");
        notice.write();

    }
}
