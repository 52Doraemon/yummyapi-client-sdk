package hzu.world.yummyapiclientsdk.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YummyLogger {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private String level;
    private String format;

    public void log(String message) {
        log(level, message);
    }

    public void log(String level, String message) {
        switch (level.toUpperCase()) {
            case "DEBUG":
                log.debug(formatMessage(message));
                break;
            case "INFO":
                log.info(formatMessage(message));
                break;
            case "WARN":
                log.warn(formatMessage(message));
                break;
            case "ERROR":
                log.error(formatMessage(message));
                break;
            default:
                log.info(formatMessage(message));
                break;
        }
    }

    /**
     * 根据 format 来对 message 进行格式化处理
     * 例如：JSON 格式、XML 格式等
     * @param message
     * @return
     */
    private String formatMessage(String message) {
        if ("JSON".equalsIgnoreCase(format)) {
            return formatJson(message);
        } else if ("XML".equalsIgnoreCase(format)) {
            return formatXml(message);
        } else {
            return String.format("[%s] %s", format, message);
        }
    }

    private String formatJson(String message) {
        try {
            return objectMapper.writeValueAsString(new LogMessage(format, message));
        } catch (JsonProcessingException e) {
            return String.format("{\"error\": \"Cannot format message: %s\"}", e.getMessage());
        }
    }

    private String formatXml(String message) {
        return String.format("<log><format>%s</format><message>%s</message></log>", format, message);
    }

    // 内部类，用于 JSON 格式化
    static class LogMessage {
        private final String format;
        private final String message;

        public LogMessage(String format, String message) {
            this.format = format;
            this.message = message;
        }

        public String getFormat() {
            return format;
        }

        public String getMessage() {
            return message;
        }
    }
}
