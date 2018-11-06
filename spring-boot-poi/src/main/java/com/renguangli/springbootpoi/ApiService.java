package com.renguangli.springbootpoi;

import java.util.List;
import java.util.Map;

/**
 * ApiService
 *
 * @author renguangli 2018/11/2 11:12
 * @since JDK 1.8
 */
public interface ApiService {

    List<Map<String, Object>> lsitApis();

    List<Map<String, Object>> doListApis();
}
