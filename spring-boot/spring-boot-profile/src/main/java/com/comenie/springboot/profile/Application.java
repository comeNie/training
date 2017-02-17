package com.comenie.springboot.profile;

import com.comenie.springboot.profile.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by 波 on 2017/2/17.
 *   外部配置：
 *   1 随机值。 在application.properties文件中。 可以配置随机值。
 *   2 命令行参数：以'--'开头，例如：  （--server.port=9000  ）转化成一个 property ，并将其添加到SpringEnvironment
 *   禁用添加到Environment，  SpringApplication.setAddCommandLineProperties(false) 。
 *   3 属性文件：
 *    加载优先级： 当前目录下的 /config  子目录。---》 当前目录。---》当前目录。--》classpath下的 /config  包---》classpath根路径（root）
 *    属性配置文件更名：  java -jar myproject.jar --spring.config.name=myproject
 *   4 不同配置文件：
 *    profile-specific属性也能通过命名惯例 application-{profile}.properties  定义
 *   5 占位符：
 *     当使用 application.properties  定义的属性时，Spring会先通过已经存在的 Environment  查找该属性，所以你可以引用事先定义的值（比如，系统属性）
 *   6 配置文件。 @ConfigurationProperties
 *
 *   Profile设定：
 *   1  --spring.profiles.active=prod 指定
 *   2  SpringApplication.setAdditionalProfiles(…) 设定
 *   3  ConfigurableEnvironment  接口设定
 *
 *
 */
@SpringBootApplication
public class Application  implements CommandLineRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private UserService userService;
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setAdditionalProfiles("dev");
        application.run(args);
//        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
       LOGGER.warn("properties-----:{}", userService.getUserProtertiesString());
    }
}
