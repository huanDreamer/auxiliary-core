package top.sillyfan.auxiliaryplatform.util;

import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.sillyfan.auxiliaryplatform.config.AuxiliaryProperties;

import java.io.File;

@Component
@Slf4j
public class QiniuUploader {

    @Autowired
    AuxiliaryProperties properties;

    /**
     * 上传文件到七牛云
     */
    public void upload(File file, String key) {

        UploadManager uploadManager = new UploadManager(new Configuration());
        Auth auth = Auth.create(properties.getAccessKey(), properties.getSecretKey());
        String token = auth.uploadToken(properties.getBucketName());
        try {
            Response r = uploadManager.put(FileUtils.readFileToByteArray(file), key, token);
        } catch (Exception e) {
            log.error("上传图片到七牛云失败:", e);
        }

    }
}
