package my.own.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
//文件的字符输入流
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("file.encoding"));
        //1.创建或指定源
        File file = new File("E:\\localtest\\home/20180124_A800_RetentionPhotosSync_1902_0009.REQ");
        FileReader fileReader = new FileReader(file);
        //读一个字符
        int c=fileReader.read();
        System.out.println((char)c);
        //读多个字符
        char[] buffer = new char[10];
        int read = -1;
        while(( read= fileReader.read(buffer))!=-1){
            System.out.println(new String(buffer,0,read));
        }
        fileReader.close();

    }
}
