package my.own.io.buffer;

import java.io.*;

public class Buffered字符Demo {
    public static void main(String[] args) throws IOException {
        //输出
        BufferedWriter bu = new BufferedWriter(new FileWriter(new File("e:/456123.txt")));
        bu.write("君不见黄河之水天上来");
        //进行换行  write(lineSeparator);
        bu.newLine();
        bu.write("奔流到海不复还");
        bu.close();


        //输入
        BufferedReader bufferedReader= new BufferedReader(new FileReader(new File("e:/456123.txt")));
        //可以进行行读
        String line =null;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
