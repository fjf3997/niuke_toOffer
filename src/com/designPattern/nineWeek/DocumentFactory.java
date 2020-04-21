package com.designPattern.nineWeek;

public class DocumentFactory {
    public OfficialDocument getDocument(String type){
        if(type==null||type.equals(""))
            return null;
        if(type.equalsIgnoreCase("info")){
            return DocumentCache.getDocument("info");

        }
        if (type.equalsIgnoreCase("notice"))
            return DocumentCache.getDocument("notice");
        return null;
    }

}
