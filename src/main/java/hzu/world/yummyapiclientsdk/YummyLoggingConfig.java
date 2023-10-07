package hzu.world.yummyapiclientsdk;

import hzu.world.yummyapiclientsdk.entity.YummyLogger;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
// 多组件扫描
@ComponentScan
// 配置类
@Configuration
// 设置application配置文件配置信息前缀
@ConfigurationProperties(prefix = "yummyapi.client.logging")
public class YummyLoggingConfig {

    private String logLevel;
    private String logFormat;

    @Bean
    public YummyLogger yummyApiLogger() {
        YummyLogger logger = new YummyLogger();
        logger.setLevel(logLevel);
        logger.setFormat(logFormat);
        return logger;
    }
}
