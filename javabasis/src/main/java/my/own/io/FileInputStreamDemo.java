package my.own.io;

import java.io.FileInputStream;
import java.util.Arrays;

//文件字节输入流
public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("e:/file.txt");
        int bb = fileInputStream.read();
        System.out.println(bb);
        byte[] abc = new byte[1024];
        int num = fileInputStream.read(abc);
        System.out.println(Arrays.toString(abc));//去除的字节数没有1024个
        System.out.println(new String(abc).length());  //字节数组装换为String 仍然是1024长度
        String str = new String(abc,0,num);
        System.out.println(str);
        System.out.println(str.length());
        fileInputStream.close();
        /*通用方式******************/
        FileInputStream fileInputStream1 = new FileInputStream("e:/uncompress.txt");
        byte[] buffer = new byte[512];
        int readline=-1;
        while((readline=fileInputStream1.read(buffer))!=-1){
            System.out.println(new String(buffer,0,readline));
        }

    }
}
