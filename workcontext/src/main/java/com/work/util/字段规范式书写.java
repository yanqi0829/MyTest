package com.work.util;

import java.util.ArrayList;
import java.util.List;

public class 字段规范式书写 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(10);
        String s = "A";
        list.add(s);
        System.out.println(list); //[A]
        s=null;
        System.out.println(list);//[A]
        list.clear();
        System.out.println(list);
    }
}
