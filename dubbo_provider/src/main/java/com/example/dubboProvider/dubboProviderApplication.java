package com.example.dubboProvider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;


@SpringBootApplication
@MapperScan("com.example.dubboProvider.dao")
public class dubboProviderApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoProviderApplication.class, args);
        new SpringApplicationBuilder(dubboProviderApplication.class)
                .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
                    Environment environment = event.getEnvironment();
                    int port = environment.getProperty("embedded.zookeeper.port", int.class);
                    new EmbeddedZooKeeper(port, false).start();
                }).run(args);
    }
}
