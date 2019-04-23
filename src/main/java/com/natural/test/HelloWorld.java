package com.natural.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**测试maven生成可执行main方法的jar包*/
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("这是一个Maven项目");
        int[] fieldNum = {4, 2, 6, 30, 30, 8, 8, 1, 6, 2, 200, 40, 40, 40, 2, 200, 40, 2, 200, 40, 40, 40, 2, 200, 40, 40, 20, 400, 20, 400, 20, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
                40, 40, 40, 40,40};
        System.out.println(fieldNum.length);


        Person p1= new Person("999","111");
        Person p3= new Person("000","333");
        Person p2= new Person("456","222");

        List<Person> plist = new ArrayList<Person>();
        plist.add(p1);
        plist.add(p2);
        plist.add(p3);
        Collections.sort(plist);
        System.out.println(plist.get(0).getTradeTime());
    }
    public String say(){
        return "11";
    }



}



class Person implements  Comparable{
    public Person(String tradeTime, String tradeId) {
        this.tradeTime = tradeTime;
        this.tradeId = tradeId;
    }

    String tradeTime;
    String tradeId;

    public int compareTo(Object o) {
        Person pp=(Person) o;

        return pp.tradeTime.compareTo(tradeTime);
    }

    @Override
    public String toString() {
        return "Person{" +
                "tradeTime='" + tradeTime + '\'' +
                ", tradeId='" + tradeId + '\'' +
                '}';
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }
}
