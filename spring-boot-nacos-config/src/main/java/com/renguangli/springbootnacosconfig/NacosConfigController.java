package com.renguangli.springbootnacosconfig;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-boot-nacos-config-client
 * Created by renguangli at 2019/1/25 11:31
 *
 * @since JDK1.8
 */
@RestController
public class NacosConfigController {

    @NacosValue(value = "${name:dali}", autoRefreshed = true)
    private String name;

    @GetMapping("/name")
    public String name() {
        return name;
    }
}
