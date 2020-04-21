package com.designPattern.nineWeek;

public abstract class OfficialDocument implements Cloneable {

    private String id;
    protected String type;

    abstract void write();

    public String getType(){return type;}
    public String getId(){return  id;}
    public void setId(String id){
        this.id = id;
    }
    //------------------------------------具体原型角色，定义用于复制现有实例来生成新实例的方法
    //浅拷贝
    @Override
    public  Object clone(){
        Object clone = null;
        try{
            //没有构造函数的调用、内存的复制 ,速度快
            clone = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}
