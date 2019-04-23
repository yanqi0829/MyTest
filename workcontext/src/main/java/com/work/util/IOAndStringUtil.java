package com.work.util;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOAndStringUtil {

    //String –> InputStream
    public static InputStream Str2Io(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

    //InputStream–>String
    public static String Io2Str(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }



    /**
     * <p>方法名称：IO流转base64字符串</p>
     * <p>方法说明：</p>
     * @param inputStream
     * @return String
     * @autho wangyq2832
     * @time 2018年12月10日 16:31:09
     */
    public static String inputStream2Base64String(InputStream inputStream) throws IOException {
        String aString = "";
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            aString = Base64.encodeBase64String(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aString;
    }
    public static InputStream Base64String2inputStream(String str) throws IOException {
      return new ByteArrayInputStream(Base64.decodeBase64(str));
    }




}
