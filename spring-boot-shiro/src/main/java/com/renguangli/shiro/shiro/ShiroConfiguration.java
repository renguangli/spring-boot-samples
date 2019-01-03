package com.renguangli.shiro.shiro;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ShiroConfiguration
 *
 * @author renguangli 2018/10/29 20:14
 * @since JDK 1.8
 */
@Configuration
public class ShiroConfiguration {

    @Bean("authorizer")
    public Realm realm() {
        return new ShiroRealm();
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        // logged in users with the 'admin' role
        chainDefinition.addPathDefinition("/info", "anon");
        // logged in users with the 'admin' role
        chainDefinition.addPathDefinition("/admin", "roles[admin]");
        // logged in users with the 'document:read' permission
        chainDefinition.addPathDefinition("/user", "roles[user]");
        // all other paths require a logged in user
        chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }
}
