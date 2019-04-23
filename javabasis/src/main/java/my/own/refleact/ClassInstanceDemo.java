package my.own.refleact;

import java.util.Date;

public class ClassInstanceDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //方式1  class属性
        Class<java.util.Date> clz1 = java.util.Date.class;
        //方式2
        Object object = new Date();
        Class clz2 = object.getClass();
        //方式3 通过Class类的静态方法 forName(String className)
        Class clz3 = Class.forName("java.util.Date");
        System.out.println(clz1);
        System.out.println(clz2);
        System.out.println(clz3);
        System.out.println(clz1==clz2);//true
    }
}
