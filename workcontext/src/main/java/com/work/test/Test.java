package com.work.test;

public class Test {
    public static void main(String[] args) {
        String string = "asdas";
        System.out.println(string.endsWith(""));
           String END_BREAK = "^" + new String(new byte[]{0x02}) + new String(new byte[]{0x03}) + "^";
        System.out.println(END_BREAK.length());
        System.out.println("".length());
    }
}
