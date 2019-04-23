package my.own.io;

import java.io.*;
import java.util.Properties;

public class LoadPropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        InputStream in =  new FileInputStream(new File("javabasis/db.properties"));
        p.load(in);
        System.out.println(p);
    }
}
