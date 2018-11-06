package com.renguangli.springbootpoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/*
 *
 * Created by renguangli at 2018/8/25 12:18
 * @since JDK1.8
 */
@Controller
public class PoiController {

    @Resource
    private ApiService apiService;

    @Value("${get-tenant-id.url}")
    private String getTenantIdUrl;

    @GetMapping("/")
    public List<Map<String, Object>> lsitApis(HttpServletResponse response) {
        String headingMapping = "TENANT_NAME:租户名称,TENANT_ID:租户ID,USERNAME:用户名称,API_PROVIDER:用户名ID,API_NAME:API名称,STATE:API状态,CONTEXT:API编码,API_VERSION:版本,VISIBILITY:可见性,VISIBLEROLES:可见租户,DESCRIPTION:描述,CREATED_TIME:创建时间";
        List<Map<String, Object>> lsitApis = apiService.doListApis();
        try (OutputStream os = response.getOutputStream();){
            response.reset();//清空输出流
            //下面是对中文文件名的处理
            response.setCharacterEncoding("UTF-8");//设置相应内容的编码格式
            response.setHeader("Content-Disposition","attachment;filename=APIS.xls");
            response.setContentType("application/msexcel");//定义输出类型
            PoiUtils.writeExcel(response, headingMapping, lsitApis);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
