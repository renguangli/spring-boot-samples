package com.renguangli.shiro.service.impl;

import com.renguangli.shiro.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * PermissionServiceImpl
 *
 * @author renguangli 2018/10/29 20:53
 * @since JDK 1.8
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Override
    public Set<String> listPermissionsByUsername(String username) {
        return new LinkedHashSet<>();
    }

}
