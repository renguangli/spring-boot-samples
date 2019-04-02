package com.renguangli.shiro.service;

import java.util.Set;

/**
 * RoleService
 *
 * @author renguangli 2018/10/29 20:52
 * @since JDK 1.8
 */
public interface RoleService {

    Set<String> listRolesByUsername(String username);

}
