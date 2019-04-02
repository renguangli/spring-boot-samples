package com.renguangli.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 *
 * Created by renguangli at 2018/10/16 20:18
 * @since JDK1.8
 */
@Component
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
