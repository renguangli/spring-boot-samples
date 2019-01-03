package com.renguangli.oauth2client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * GithubProperties
 *
 * @author renguangli 2018/10/12 14:06
 * @since JDK 1.8
 */
@Component("githubProperties")
@ConfigurationProperties(prefix = "github")
public class GithubProperties {

    private String clientId;

    private String clientSecret;

    private String loginUri;

    private String redirectUri;

    private String accessTokenUri;

    private GithubProperties(){}

    public GithubProperties(String clientId, String clientSecret, String loginUri, String redirectUri, String accessTokenUri) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.loginUri = loginUri;
        this.redirectUri = redirectUri;
        this.accessTokenUri = accessTokenUri;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getLoginUri() {
        return loginUri;
    }

    public void setLoginUri(String loginUri) {
        this.loginUri = loginUri;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getAccessTokenUri() {
        return accessTokenUri;
    }

    public void setAccessTokenUri(String accessTokenUri) {
        this.accessTokenUri = accessTokenUri;
    }

    @Override
    public String toString() {
        return "GithubProperties{" +
                "clientId=" + clientId +
                ", clientSecret=" + clientSecret +
                ", loginUri=" + loginUri +
                ", redirectUri=" + redirectUri +
                ", accessTokenUri=" + accessTokenUri +
                "}";
    }

}
