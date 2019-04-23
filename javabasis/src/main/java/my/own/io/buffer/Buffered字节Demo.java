package my.own.io.buffer;

import java.io.*;
//BufferedInputStream 与BufferedOutputStream   字节缓冲流
public class Buffered字节Demo {
    public static void main(String[] args) throws IOException {
        //字节缓冲输出流
        File file = new File("e:/222.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file,true));
        String str="中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中";
        bufferedOutputStream.write(str.getBytes());
        bufferedOutputStream.close();
        //字节缓冲输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] b = new byte[1024];
        int len=-1;
        while ((len=bufferedInputStream.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
        bufferedInputStream.close();

    }
}
