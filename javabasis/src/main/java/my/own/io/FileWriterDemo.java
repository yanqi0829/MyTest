package my.own.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

//文件的字符输出流
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("e:/111.txt");
        Writer writer= new FileWriter(file,true);
        String sr="你好吗";
        writer.write('c');
        writer.write(sr);
        //注释掉close，发现没有数据被写入，因为在缓冲区中
        writer.flush();
        //在关闭资源之前会自动调用flush方法
        writer.close();
    }
}
