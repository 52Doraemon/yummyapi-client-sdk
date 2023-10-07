package hzu.world.yummyapiclientsdk;

import hzu.world.yummyapiclientsdk.entity.YummyLogger;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = YummyLoggingConfig.class)
class YummyapiClientSdkApplicationTests {

    @Test
    void contextLoads() {
        // 使用示例
        YummyLogger yummyLogger = new YummyLogger("INFO", "JSON");
        yummyLogger.log("This is an info message.");

        // 动态改变日志级别和格式
        yummyLogger.setLevel("ERROR");
        yummyLogger.setFormat("XML");
        yummyLogger.log("This is an error message.");

    }

}
