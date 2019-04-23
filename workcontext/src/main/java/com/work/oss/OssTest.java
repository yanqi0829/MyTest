package com.work.oss;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.work.util.IOAndStringUtil;
import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * OSS product environment test watermark and url
 */
public class OssTest {
    //V3生产
//    private static String endpoint = "http://oss-cn-langfang-lt-d01-a.i.super.unicom.local";
//    private static String accessKeyId = "kexJQFywrZIRymTk";
//    private static String accessKeySecret = "654r9OwKjQXtqea7eSxkWKwGgwwVmp";
//    private static String bucketName = "prod-cust-file";

    /**
     * 生产V2
     */
    private static String endpoint = "http://oss-cn-langfang-lthk-d01-a.super.unicom.local";
    private static String accessKeyId = "FqZxNl1Ub5ZkFq7v";
    private static String accessKeySecret = "fTqQLZV2ZbHDFu3RUmw8lzO878JLRs";
    private static String bucketName = "prod-cust-file";

    //V2测试
//    private static String endpoint = "http://oss-cn-langfang-ltpoc-d01-a.develop.unicom.local/";
//    private static String accessKeyId = "R9XXQyV4uyO0wiag";
//    private static String accessKeySecret = "barp8qaPrCTXDZ7atlV0qAsXBhyCHQ";
//    private static String bucketName = "test-retention-photos";
    private static String singleBucket = "photo-query-single";

    public static void main(String[] args) {


        ClientConfiguration conf = new ClientConfiguration();
        conf.setSLDEnabled(true);
        // 不开启支持CNAME选项
        conf.setSupportCname(false);
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret, conf);
        //TODO 根据key 从OSS获取文件
        System.out.println(ossClient.doesObjectExist(bucketName, "$37170117791557910017_20171109171338.jpg"));
        ObjectMetadata aMetadata= ossClient.getObject(new GetObjectRequest(bucketName, "37170117791557910017_20171109171338.jpg"),
                new File("E:/37170117791557910017_20171109171338.jpg"));
        if (true){
            return;
        }
        //TODO 测试io流重复使用
        File zipdir = new File("E:\\localtest\\zipdata\\wo/20190222_A800_SceneAndCertPhotosSync_hbpre_0018.zip");
        Charset gbk = Charset.forName("GBK");
        Map<String, String> jpgMap = new HashMap<String, String>();
        int imgNum;
        ZipInputStream zin = null;
        try {
            ZipFile zf = new ZipFile(zipdir, gbk);
            InputStream inZip = new BufferedInputStream(new FileInputStream(zipdir));
            zin = new ZipInputStream(inZip);
            ZipEntry ze;
            InputStream inputStream;
            imgNum = 0;
            while ((ze = zin.getNextEntry()) != null) {
                if (ze.isDirectory()) {
                    continue;
                } else {
                    long size = ze.getSize();
                    imgNum++;
                    inputStream = zf.getInputStream(ze);
                    int length = ze.getName().split("/").length;
                    String photoName=ze.getName().split("/")[length - 1];
                   System.out.println(inputStream.available());
                    /***/
                    try {

                        //io流存入string
                        String sss=   IOAndStringUtil.inputStream2Base64String(inputStream);

                        ossClient.putObject(singleBucket, photoName, IOAndStringUtil.Base64String2inputStream(sss));

                        ossClient.putObject(bucketName, photoName, IOAndStringUtil.Base64String2inputStream(sss));

                    } catch (OSSException oe) {
                        oe.printStackTrace();
                    } catch (ClientException ce) {
                        ce.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {}




                        /***/
                }
            }
        } catch (Exception ee) {
            return;
        } finally {
            try {
                if (zin != null) {
                    zin.closeEntry();
                }
            } catch (Exception e) {
            }
        }


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




    public static void main1(String[] args) throws IOException {
        String str="asdasfasdfasfasf";
        InputStream in=IOAndStringUtil.Str2Io(str);
        System.out.println(in.available());
      String str1=  IOAndStringUtil.Io2Str(in);
        System.out.println(str1);

        InputStream in1=IOAndStringUtil.Str2Io(str1);
        System.out.println(in1.available());
    }
    }