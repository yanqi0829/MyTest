package my.own.io;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class 编码和解码 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //string -》byte[] 编码
        String string = "中国";
        byte[] bs= string.getBytes("GBK");
        System.out.println(Arrays.toString(bs));
        //byte[]-> string  解码
        System.out.println(new String(bs,"GBK"));
    }
}
