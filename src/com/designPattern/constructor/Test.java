package com.designPattern.constructor;

public class Test {
    public static void main(String[] args) {
        Facotry facotry = new ResumeFactory();
        Document resumeDocument = facotry.factoryMethod();
        String content = resumeDocument.content();
        System.out.println(content);
    }
}
