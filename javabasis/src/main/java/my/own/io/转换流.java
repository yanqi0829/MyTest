package my.own.io;

import java.io.*;

public class 转换流 {
    public static void main(String[] args) throws IOException {
        File filea = new File("e:/asdas.txt");
        String asteing="asdas你d";
        FileOutputStream fos = new FileOutputStream(filea, true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(asteing );
        bw.newLine();
        // 注意关闭的先后顺序，先打开的后关闭，后打开的先关闭,
        bw.close();
        osw.close();
        fos.close();

    }
}
