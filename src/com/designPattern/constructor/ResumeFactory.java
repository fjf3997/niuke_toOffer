package com.designPattern.constructor;

public class ResumeFactory implements Facotry {

    @Override
    public Document factoryMethod() {
        return new ResumeDocument();
    }
}
