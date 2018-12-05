package com.renguangli.shiro.service.impl;

import com.renguangli.shiro.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

/**
 * RoleServiceImpl
 *
 * @author renguangli 2018/10/29 20:52
 * @since JDK 1.8
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Override
    public LinkedHashSet listRolesByUsername(String username) {
        LinkedHashSet<String> roles = new LinkedHashSet<>();
        if ("admin".equals(username)) {
            roles.add("admin");
        } else {
            roles.add("user");
        }
        return roles;
    }
}
