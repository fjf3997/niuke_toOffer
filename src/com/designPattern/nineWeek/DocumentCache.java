package com.designPattern.nineWeek;

import java.util.Hashtable;

public class DocumentCache {
    private static Hashtable<String,OfficialDocument> documentMap;
    static {
        documentMap = new Hashtable<>();
        localCache();
    }
    public  static OfficialDocument getDocument(String type){
        assert type=="info"||type=="notice";
        OfficialDocument document = documentMap.get(type);
        return (OfficialDocument) document.clone();
    }
    private static void localCache(){
        Notice notice = Notice.getInstance();
        notice.setId("1");
        documentMap.put(notice.getType(),notice);
        Info info = Info.getInstance();
        info.setId("2");
        documentMap.put(info.getType(),info);

    }
}
