package com.example.demo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * DemoAutoConfigure
 *
 * @author renguangli 2018/12/5 21:06
 * @since JDK 1.8
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
public class DemoAutoConfigure {
}

