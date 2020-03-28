package com.fjf.os3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fifo {
    //块长大小
    private final static int length = 128;
    //内存块大小
    private final static int size = 3;
    //缺页中断次数
    private int count;
    //当前进程空闲内存块号
    private int rSize = 0;
    private List<Order> orders;
    private List<Page> pages;
    private Queue<Page> queue;

    public Fifo() {
        orders = new ArrayList<>();
        pages = new ArrayList<>();
        queue = new LinkedList<Page>();
        init();
    }

    /**
     * 初始化order集合和page集合
     */
    void init(){
        Page page1 = new Page(0,false,0,11);
        Page page2 = new Page(1,false,0,22);
        Page page3 = new Page(2,false,0,33);
        Page page4 = new Page(3,false,0,44);
        Page page5 = new Page(4,false,0,55);
        Page page6 = new Page(5,false,0,66);
        Page page7 = new Page(6,false,0,77);
        pages.add(page1);
        pages.add(page2);
        pages.add(page3);
        pages.add(page4);
        pages.add(page5);
        pages.add(page6);
        pages.add(page7);
        Order order1 = new Order("+",0,70);
        Order order2 = new Order("移位",4,53);
        Order order3 = new Order("+",1,50);
        Order order4 = new Order("+",5,23);
        Order order5 = new Order("x",2,15);
        Order order6 = new Order("存",1,37);
        Order order7 = new Order("存",3,21);
        Order order8 = new Order("取",2,78);
        Order order9 = new Order("取",0,56);
        Order order10 = new Order("+",4,1);
        Order order11 = new Order("-",6,40);
        Order order12 = new Order("+存",6,84);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);
        orders.add(order8);
        orders.add(order9);
        orders.add(order10);
        orders.add(order11);
        orders.add(order12);
    }
    public static void main(String[] args) {
        Fifo fifo = new Fifo();
        fifo.run();
        System.out.println("总缺页总断次数："+fifo.count);


    }

    /**
     * 判断页号是否在内存中
     * @param page
     * @return
     */
    private boolean inMemory(Page page){
        return page.isFlag();
    }

    /**
     * 获取绝对地址
     * @param page
     * @param order
     * @return
     */
    private int getAddr(Page page,Order order){
        return page.getNum()*length+order.getUnit();
    }

    /**
     * 运行
     */
    public void run(){
        for(int i=0;i<orders.size();i++){
            //取指令
            Order order = orders.get(i);
            Page page = pages.get(order.getId());
            if(page.isFlag()){
                System.out.println("操作："+order.getOperate()+"\t|"+"页号："+order.getId()+"\t|"+"绝对地址:"+getAddr(page,order));
            }else{
                count++;
                if(rSize<size){
                    System.out.println(page.getId()+"页号表示发生缺页中断");
                    rSize++;
                    page.setFlag(true);
                    page.setNum(rSize);
                    queue.add(page);
                    System.out.println("操作："+order.getOperate()+"\t|"+"页号："+order.getId()+"\t|"+"绝对地址"+getAddr(page,order));

                }else {
                    System.out.println(page.getId()+"页号表示发生缺页中断");
                    Page p = queue.poll();
                    p.setFlag(false);
                    page.setNum(p.getNum());
                    page.setFlag(true);
                    queue.add(page);
                    System.out.println("移除页："+p.getId()+"到磁盘，"+"加入页："+page.getId()+"到内存");
                    System.out.println("操作："+order.getOperate()+"\t|"+"页号："+order.getId()+"\t|"+"绝对地址"+getAddr(page,order));

                }


            }
        }
    }
}
