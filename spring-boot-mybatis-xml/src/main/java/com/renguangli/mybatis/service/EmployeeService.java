package com.renguangli.mybatis.service;

import com.renguangli.mybatis.bean.Employee;
import com.renguangli.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EmployeeService
 *
 * @author renguangli 2018/10/30 14:51
 * @since JDK 1.8
 */
@Service("employeeService")
@CacheConfig(cacheNames = "employee")
public class EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Cacheable
    public List<Employee> listEmployees(Employee employee, Integer page, Integer size) {
        return employeeMapper.listEmployees(employee, page, size);
    }

    public Long countEmployee(Employee employee) {
        return employeeMapper.countEmployee(employee);
    }


    @Cacheable //能够根据方法的请求参数对其结果进行缓存
    public Employee get(Integer integer) {
        return employeeMapper.get(integer);
    }

    public int save(Employee pojo) {
        return employeeMapper.save(pojo);
    }

    @CacheEvict(beforeInvocation = true)
    public int delete(Integer integer) {
        return employeeMapper.delete(integer);
    }

    @CachePut(key = "#result.empNo")
    public int update(Employee pojo) {
        return employeeMapper.update(pojo);
    }
}
