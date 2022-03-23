package wyu.xwen.ossService.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import wyu.xwen.ossService.service.AliyunService;
import wyu.xwen.ossService.utils.ConstantPropertiesUtil;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class AliyunServiceImpl implements AliyunService {


    @Override
    public String uploadUserPhoto(MultipartFile file) {
        String fileHost = "user/userPhoto/";
        return upload(file, fileHost);
    }

    @Override
    public String uploadCarImag(MultipartFile file) {
        String fileHost = "user/carImage/";
        return upload(file, fileHost);
    }

    @Override
    public String uploadPetImag(MultipartFile file) {
        String fileHost = "user/petImage/";
        return upload(file, fileHost);
    }

    @Override
    public String UploadCommunityThumb(MultipartFile file) {

        String fileHost = "community/communityThumb";
        return upload(file,fileHost);
    }

    @Override
    public String uploadRepairImag(MultipartFile file,String folder) {
        String fileHost = folder+"/";
        return upload(file, fileHost);
    }

    public String upload(MultipartFile file, String fileHost) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ConstantPropertiesUtil.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);


        if (!ossClient.doesBucketExist(bucketName)) {
            /*if bucket not exist*/
            ossClient.createBucket(bucketName);
            //设置oss实例的访问权限：公共读
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        }

        /*if bucket exist*/
        String fileName = "";
        try {


            InputStream inputStream = file.getInputStream();

            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String dateString = dateFormat.format(date)+"/";
            fileName = fileHost+dateString+uuid+file.getOriginalFilename();
            System.out.println(fileName);
            ossClient.putObject(bucketName, fileName, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "https://" +bucketName+"."+endpoint+"/"+fileName;
    }
}
