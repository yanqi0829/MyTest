package com.natural.retention.photo;

import java.io.*;
import java.util.Arrays;


public class 证件照检验字段 {
    public static final String FIELD_BREAK = "^" + new String(new byte[]{0x01}) + new String(new byte[]{0x02}) + "^";
    public static final String END_BREAK = "^" + new String(new byte[]{0x02}) + new String(new byte[]{0x03}) + "^";
    public static final String END_BREAK1 = "^" + new String(new byte[]{0x02}) + new String(new byte[]{0x03}) + "^";

    public static void main(String[] args) throws IOException {
        int[] fieldNum = {4, 2, 6, 30, 30, 8, 8, 1, 6, 2, 200, 40, 40, 40, 2, 200, 40, 2, 200, 40, 40, 40, 2, 200, 40, 40, 20, 400, 20, 400, 20, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
                40, 40, 40, 40,40};
        int[] notNull = {1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,1};
//        String string2 = "9702^\u0001\u0002^97^\u0001\u0002^971^\u0001\u0002^^\u0001\u0002^2019012284285730^\u0001\u0002^^\u0001\u0002^20190122^\u0001\u0002^0^\u0001\u0002^0049^\u0001\u0002^01^\u0001\u0002^张岳^\u0001\u0002^230128198607150410^\u0001\u0002^9718031888622597^\u0001\u0002^2019012232632457^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^045104726951^\u0001\u0002^97b1354^\u0001\u0002^哈尔滨市道里区弘晟手机大卖场^\u0001\u0002^97b1354^\u0001\u0002^哈尔滨市道里区弘晟手机大卖场^\u0001\u0002^hlsc-lixf21^\u0001\u0002^^\u0001\u0002^97WO201901221893600200001.jpg^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^97WO201901221170288600001A^\u0001\u0002^97WO201901221170289500001B^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0002\u0003^";
//        if (!string2.endsWith(证件照检验字段.END_BREAK1)) {
//            System.out.println("行结束符有误");
//            return;
//        }
        String string2 ="";

        File file = new File("C:\\Users\\wangyq\\Desktop\\下载内容/20190130_A800_OnlineOpenPhotosSync_A700_0001.REQ");
        BufferedReader r = null;
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            r = new BufferedReader(new InputStreamReader(in, "gbk"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        while ((string2 = r.readLine()) != null) {
            string2 = string2.substring(0, string2.length() - 4);
            String[] arr = string2.split("\\^\\^");
//		arr = copyOf(arr, 48);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(i + 1 + "...." + arr[i]);
                if (arr[i].length() == 0 && notNull[i] == 1) {
                    System.out.println("必填字段为空....." + (i + 1));
                }
                if (arr[i].length() > fieldNum[i]) {
                    System.out.println("字段偏长，最大：" + fieldNum[i] + "实际有：" + arr[i].length());
                }
                if (arr[i].length() != 0 && i >= 32 && i <= 35 && (arr[32 + (i - 32) * 2 + 4].length() == 0 || arr[32 + (i - 32) * 2 + 4 + 1].length() == 0)) {
                    System.out.println("请检查第" + (i + 1) + "个字段的证件照");
                }
            }
            // System.out.println("此条订单的字段个数为：" + arr.length);
        }
//}

    }
}

