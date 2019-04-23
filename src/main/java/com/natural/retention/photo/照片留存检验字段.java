package com.natural.retention.photo;

public class 照片留存检验字段 {
	public static void main(String[] args) {
		/** 照片留存 */
		int[] fieldNum = { 4, 2, 6, 30, 30, 8, 8, 1, 6, 2, 200, 40, 40, 40, 2, 200, 40, 2, 200, 40, 40, 40, 2, 200, 40, 40, 20, 400, 20, 400, 20, 40, 40, 40, 40, 40, 60, 60, 60, 60 };
		int[] notNull = { 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		String string2 = "7400|74|741|402842||20190107||0|05|33|湖南省统计局|11430000006122383B||||||||||||||17650316683|A11038531|10010.com|A11038531|10010.com|A12193||11430000006122383B20181102145849122678_H.jpg|||||||";
		String[] arr = string2.split("\\|", -1);
		for (int i = 0; i < 40; i++) {
			System.out.println(i + 1 + "...." + arr[i]);
			if (arr[i].length() == 0 && notNull[i] == 1) {
				System.out.println("必填字段为空....." + (i + 1));

			}
			if (arr[i].length() > fieldNum[i]) {
				System.out.println("字段偏长，最大：" + fieldNum[i] + "实际有：" + arr[i].length());

			}

		}

		System.out.println("此条订单的字段个数为：" + arr.length);

	}
}
