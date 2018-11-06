package com.renguangli.springbootpoi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ApiServiceImpl
 *
 * @author renguangli 2018/11/2 11:13
 * @since JDK 1.8
 */
@Service("apiService")
public class ApiServiceImpl implements ApiService {

    private CountDownLatch latch;

    private ExecutorService executorService = Executors.newFixedThreadPool(100);

    @Value("${get-tenant-id.url}")
    private String getTenantIdUrl;

    @Value("${get-chinese-name.url}")
    private String getChineseNameUrl;

    private final RestTemplate restTemplate;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ApiServiceImpl(JdbcTemplate jdbcTemplate, RestTemplate restTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.restTemplate = restTemplate;
    }

    /**
     * 对API数据进行处理：1、Unicode 转中文 2、添加 租户编号和租户名称字段
     * @return 包含租户编号和租户名称的API列表
     */
    public List<Map<String, Object>> doListApis() {
        List<Map<String, Object>> listApis = this.lsitApis();
        latch = new CountDownLatch(listApis.size());
        for (Map<String, Object> api : listApis) {
            Object apiProvider = api.get("API_PROVIDER");
            Object description = api.get("DESCRIPTION");
            if (description != null) {
                api.put("DESCRIPTION", StringEscapeUtils.unescapeHtml(description.toString().replace("amp;", "")));
            }
            executorService.execute(() -> {
                try {
                    String username = restTemplate.getForObject(getChineseNameUrl, String.class, getParam(apiProvider.toString()));
                    api.put("USERNAME", getChineseName(username));

                    String tenantId = restTemplate.getForObject(getTenantIdUrl, String.class, apiProvider);
                    api.put("TENANT_ID", tenantId);
                    String tenantName = restTemplate.getForObject(getChineseNameUrl, String.class, getParam(tenantId));
                    api.put("TENANT_NAME",  getChineseName(tenantName));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return listApis;
    }

    @Override
    public List<Map<String, Object>> lsitApis() {
        String sql = "SELECT API.STATE,AA.API_PROVIDER,AA.API_NAME,AA.CREATED_TIME,AA.API_VERSION,AA.CONTEXT,AAI.DESCRIPTION,AAI.VISIBILITY,AAI.VISIBLEROLES " +
                "FROM AM_API AA,AM_API_INFO AAI," +
                "(" +
                    "SELECT API_ID,NEW_STATE STATE " +
                    "FROM AM_API_LC_EVENT A,(SELECT MAX(EVENT_DATE) EVENT_DATE FROM AM_API_LC_EVENT GROUP BY  API_ID) B " +
                    "WHERE A.EVENT_DATE = B.EVENT_DATE " +
                    //"AND NEW_STATE = 'PUBLISHED'" +
                ") API " +
                "WHERE AA.API_ID = API.API_ID AND AA.API_NAME = AAI.NAME AND AA.API_PROVIDER = AAI.PROVIDER AND AA.API_VERSION = AAI.VERSION";
        return jdbcTemplate.queryForList(sql);
    }

    private String getParam(String loginId) {
        return "{\"loginId\":\"" + loginId + "\"}";
    }

    private String getChineseName(String response) {
        JSONArray jsonArray = JSON.parseArray(response);
        try {
            return jsonArray.getJSONObject(0).getString("userName");
        } catch (IndexOutOfBoundsException e) {

        }
        return "";
    }
}
