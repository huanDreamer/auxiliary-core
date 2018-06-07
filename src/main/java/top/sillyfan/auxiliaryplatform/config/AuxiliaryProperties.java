package top.sillyfan.auxiliaryplatform.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "auxiliary.config")
public class AuxiliaryProperties {

    private String tmpPath;

    // 七牛云配置
    private String accessKey;

    private String secretKey;

    private String bucketName;

}
