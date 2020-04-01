package com.designPattern.constructor;

public class PaperFacotry implements Facotry {
    @Override
    public Document factoryMethod() {
        return new PaperDocument();
    }
}
