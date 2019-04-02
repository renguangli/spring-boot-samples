package com.renguangli.springbootnacosconfig;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "application.properties", autoRefreshed = true)
public class SpringBootNacosConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNacosConfigApplication.class, args);
    }

}

