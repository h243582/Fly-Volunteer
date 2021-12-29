package util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.Upload;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OSS_Tencent {
    public COSCredentials cred;
    public ClientConfig  clientConfig;
    public COSClient cosClient;
    public String region = "ap-shanghai"; //地域
    public String bucketName = "heyufei-1305336662";// 存储桶
    public String key = "my_img/"; // 路径  即对象键。 my_img

    public ExecutorService threadPool;
    public TransferManager transferManager;
    public SimpleDateFormat sdf ;

    public OSS_Tencent() {
        // 1 初始化用户身份信息（secretId, secretKey） https://console.cloud.tencent.com/cam/capi
        cred = new BasicCOSCredentials("AKIDY2PVXMBrCMQYUFwfGi40kPq1QcYCckdf", "z8x43NhlbFFVdW7ZptIRKyMh1A4uWtSR");
        // 设置 bucket 的地域, clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        clientConfig = new ClientConfig(new Region(region));
        // 这里建议设置使用 https 协议
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 设置最大重试次数为 4 次
        clientConfig.setMaxErrorRetry(4);
        // 3 生成 cos 客户端。
        cosClient = new COSClient(cred, clientConfig);

        threadPool = Executors.newFixedThreadPool(32);
        // 传入一个 threadPool, 若不传入线程池, 默认 TransferManager 中会生成一个单线程的线程池。
        transferManager = new TransferManager(cosClient, threadPool);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm ss");
    }


    public void show() {
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        // 设置bucket名称
        listObjectsRequest.setBucketName(bucketName);
        // prefix表示列出的object的key以prefix开始
        listObjectsRequest.setPrefix(key);
        // deliter表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
        listObjectsRequest.setDelimiter("/");
        // 设置最大遍历出多少个对象, 一次listobject最大支持1000
        listObjectsRequest.setMaxKeys(1000);
        ObjectListing objectListing = null;
        do {
            try {
                objectListing = cosClient.listObjects(listObjectsRequest);
            } catch (CosClientException e) {
                e.printStackTrace();
                return;
            }
            // common prefix表示表示被delimiter截断的路径, 如delimter设置为/, common prefix则表示所有子目录的路径
            List<String> commonPrefixs = objectListing.getCommonPrefixes();

            // object summary表示所有列出的object列表
            List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
            System.out.println("总共：" + cosObjectSummaries.size());
            for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {
                // 文件的路径key
                String key = cosObjectSummary.getKey();
                // 文件的etag
                String etag = cosObjectSummary.getETag();
                // 文件的长度
                long fileSize = cosObjectSummary.getSize();
                // 文件的存储类型
                String storageClasses = cosObjectSummary.getStorageClass();
                System.out.println("路径key：" + key + "     etag： " + etag + "     大小： " + fileSize + "     存储类型： " + storageClasses);
            }

            String nextMarker = objectListing.getNextMarker();
            listObjectsRequest.setMarker(nextMarker);
        } while (objectListing.isTruncated());
    }

    public String upload(String localFilePath,String imgName) {
        // 指定要上传的文件
        File localFile = new File(localFilePath);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key+imgName, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        String path = "https://"+bucketName+".cos."+region+".myqcloud.com/"+key+imgName;
        System.out.println(path);
        return path;
    }

    public void uploadImg() {
//        new Thread(()-> {
                try {
                    System.out.println("上传开始时间:" + sdf.format(new Date()));
                    System.out.println(bucketName);
                    //本地文件路径
                    File localFile = new File("D:\\111.jpg");
                    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
                    // 本地文件上传
                    Upload upload = transferManager.upload(putObjectRequest);
                    // 异步（如果想等待传输结束，则调用 waitForUploadResult）
//                    UploadResult uploadResult = upload.waitForUploadResult();
                    //同步的等待上传结束waitForCompletion
                    upload.waitForCompletion();
                    System.out.println("上传结束时间:" + sdf.format(new Date()));
                    System.out.println("上传成功");
                    //获取上传成功之后文件的下载地址
                    URL url = cosClient.generatePresignedUrl(bucketName , key, new Date(new Date().getTime() + 5 * 60 * 10000));
                    System.out.println(url);
                } catch (Throwable tb) {
                    System.out.println("上传失败");
                    tb.printStackTrace();
                } finally {
                    // 关闭 TransferManger
                    transferManager.shutdownNow();
                }
//        }).start();
    }

    public void download() {
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
//        // 方法1 获取下载输入流
//        COSObject cosObject = cosClient.getObject(getObjectRequest);
//        COSObjectInputStream cosObjectInput = cosObject.getObjectContent();
//        // 下载对象的 CRC64
//        String crc64Ecma = cosObject.getObjectMetadata().getCrc64Ecma();
//        // 关闭输入流
//        try {
//            cosObjectInput.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 方法2 下载文件到本地的路径，例如 D 盘的某个目录
        String outputFilePath = "D:\\123.jpg";
        File downFile = new File(outputFilePath);
        getObjectRequest = new GetObjectRequest(bucketName, key);
        ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
    }

    public void close() {
        // 关闭客户端(关闭后台线程)
        cosClient.shutdown();
    }

    public static byte[] File2byte(File tradeFile) {
        byte[] buffer = null;
        try {
            FileInputStream fis = new FileInputStream(tradeFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}
