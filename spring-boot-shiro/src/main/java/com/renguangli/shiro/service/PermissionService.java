package com.renguangli.shiro.service;

import java.util.Set;

/**
 * PermissionService
 *
 * @author renguangli 2018/10/29 20:53
 * @since JDK 1.8
 */
public interface PermissionService {

    Set<String> listPermissionsByUsername(String username);
}
