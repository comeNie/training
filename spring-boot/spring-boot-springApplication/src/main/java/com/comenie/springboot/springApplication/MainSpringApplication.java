package com.comenie.springboot.springApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 波 on 2017/2/16.
 * SpringApplication相关操作：
 *
 * 1 访问main中Args 参数。     ApplicationArguments 可以自动注入。
 * 2 SpringApplication启动后置动作：   实现 ApplicationRunner或者CommandLineRunner 中的run方法。
 * 3 ApplicationContext 创建： AnnotationConfigApplicationContext  或 AnnotationConfigEmbeddedWeb
 * ApplicationContext   可以通过 setWebEnvironment(boolean webEnvironment)  setApplicationContextClass(…)   来控制。
 * 4 监听器。 ApplicationStartedEvent-->ApplicationEnvironmentPreparedEvent-->ApplicationPreparedEvent-->ApplicationReadyEvent
 * 启动失败会发送一个失败事件，ApplicationFailedEvent
 * 5 流式构建API
 * 6 自定义SpringApplication
 * 7 自定义Banner
 * 8 启动失败。  FailureAnalyzers
 *
 */
@RestController
@SpringBootApplication
public class MainSpringApplication {

    @Autowired
    private ApplicationArgumentsCompent applicationArgumentsCompent;

    @RequestMapping("/")
    public  String home(){
        applicationArgumentsCompent.getArgs();
        return "hello world";
    }


    public static void main(String[] args) {
        SpringApplication.run(MainSpringApplication.class,args);
    }

    public  void run(String[] args){
        new SpringApplicationBuilder()
                .sources(MainSpringApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    public void manualSpringApplication(String[] args){
        SpringApplication application = new SpringApplication(MainSpringApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
