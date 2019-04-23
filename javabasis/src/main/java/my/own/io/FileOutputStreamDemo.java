package my.own.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//文件字节输出流
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file= new File("e:/file.txt");
        //true 文件追加数据
        FileOutputStream fileOutputStream= new FileOutputStream(file,true);
        fileOutputStream.write("123".getBytes());
        fileOutputStream.write(65);
        fileOutputStream.write("123".getBytes(),0,2);
        fileOutputStream.close();
    }
}
