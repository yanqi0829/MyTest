package com.natural.retention.photo;

import java.io.IOException;
import java.util.Arrays;

public class 五张照片字段检测 {

    public static final String FIELD_BREAK = "^" + new String(new byte[] { 0x01 }) + new String(new byte[] { 0x02 }) + "^";
    public static final String END_BREAK = "^" + new String(new byte[] { 0x02 }) + new String(new byte[] { 0x03 }) + "^";
    public static final String END_BREAK1 = "^" + new String(new byte[] { 0x02 }) + new String(new byte[] { 0x03 }) + "^";

    public static void main(String[] args) throws IOException {
        int[] fieldNum = {4, 2, 6, 30, 30, 8, 8, 1, 6, 2, 200, 40, 40, 40, 2, 200, 40, 2, 200, 40, 40, 40, 2, 200, 40, 40, 20, 400, 20, 400, 20, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
                40, 40, 40, 40,40};
        int[]  notNull =new int[] {1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1};
        String string2 = "1800^\u0001\u0002^97^\u0001\u0002^981^\u0001\u0002^0000000001^\u0001\u0002^^\u0001\u0002^20190123^\u0001\u0002^^\u0001\u0002^0^\u0001\u0002^100^\u0001\u0002^01^\u0001\u0002^李春阳^\u0001\u0002^23081119930621181X^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^1030100^\u0001\u0002^^\u0001\u0002^hlsc-wangpeng12^\u0001\u0002^^\u0001\u0002^A700000000000000000000001.jpg^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^A700000000000000000000001A.jpg^\u0001\u0002^A700000000000000000000001B.jpg^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^A7000000000000000000000011.jpg^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^^\u0001\u0002^A7000000000000000000000012.jpg^\u0002\u0003^";
        if (!string2.endsWith(证件照检验字段.END_BREAK1)) {
            System.out.println("行结束符有误");
            return;
        }


//		File file = new File("C:\\Users\\wangyq\\Desktop/20190114_A800_SceneAndCertPhotosSync_F500_0001.REQ");
//		BufferedReader r = null;
//		InputStream in = null;
//		try {
//			in = new FileInputStream(file);
//			r = new BufferedReader(new InputStreamReader(in, "gbk"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		while ((string2 = r.readLine()) != null) {
        string2 = string2.substring(0, string2.length() - 4);
        String[] arr = string2.split("\\^\\^");
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
