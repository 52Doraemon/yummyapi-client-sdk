package hzu.world.yummyapiclientsdk;

import hzu.world.yummyapiclientsdk.client.YummyApiClient;
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
@ConfigurationProperties("yummyapi.client")
public class YummyApiClientConfig {

    private String name;

    @Bean
    public YummyApiClient yummyApiClient(){
        System.out.println(name);
        return new YummyApiClient();
    }
}
