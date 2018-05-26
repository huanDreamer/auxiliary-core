package top.sillyfan.auxiliaryplatform.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "auxiliary.config")
public class AuxiliaryProperties {

    private Float price;

    private Integer taskExpire;

    private String tmpPath;
}
