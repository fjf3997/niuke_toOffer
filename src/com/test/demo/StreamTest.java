/*
 *  Copyright@2019 清云智通（北京）科技有限公司 保留所有权利
 */
package com.test.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fanjf@tsingyun.net
 * @date 2020/7/8 9:25
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add(null);
        list.add("a");
        list = list.stream().filter(s -> s!=null).collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
