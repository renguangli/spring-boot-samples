package com.renguangli.oauth2client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/*
 *
 * Created by renguangli at 2018/9/1 13:31
 * @since JDK1.8
 */
@Controller
public class GithubController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private GithubProperties githubProperties;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        String loginUri = githubProperties.getLoginUri()
                + "?client_id=" + githubProperties.getClientId()
                + "&redirect_uri=" + githubProperties.getRedirectUri()
                + "&state=" + UUIDUtils.uuid(8);
        return "redirect:" + loginUri;
    }

    @GetMapping("/callback")
    public String callback(HttpSession session, String code, String state) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(headers);
        params.add("client_id", githubProperties.getClientId());
        params.add("client_secret", githubProperties.getClientSecret());
        params.add("redirect_uri", githubProperties.getRedirectUri());
        params.add("code", code);
        params.add("state", state);

        String response = restTemplate.postForObject(githubProperties.getAccessTokenUri(), new HttpEntity<>(params, headers), String.class);

        ObjectMapper mapper = new ObjectMapper();
        HashMap data = mapper.readValue(response, HashMap.class);
        Object access_token = data.get("access_token");

        session.setAttribute("token", access_token);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/user")
    public String user(HttpSession session) {

        String url = "https://api.github.com/user?access_token={access_token}";
        Object token = session.getAttribute("token");
        System.out.println(token);
        return restTemplate.getForObject(url, String.class, token);
    }

}
