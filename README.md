# yummyapi-client-sdk

一个基于SpringBoot封装SDK的方式，屏蔽细节，便携调用

项目名称：yummyapi-client-sdk（客户端SDK）

有可能存在服务端SDK：yummyapi-server-sdk（服务端SDK）

# 基础依赖

Lombok，spring configuration processor（帮助开发者自动生成代码补全）

# 配置SDK包环境

1.1 改造依赖

删除测试依赖（可选）
删除使用Maven构建为Jar包方式（必需）

1.2 删除SpringBoot主类

使用配置类加载配置文件中的配置信息直接生成可使用的类，供外界使用
@Configuration：标记为配置类
@ConfigurationProperties("")：读取application配置文件的对应的配置信息注入到需要的地方

1.3 在Resources目录新建META-INF路径添加spring.factories文件

设置自动引入配置类