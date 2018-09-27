package com.renguangli.mybatis.mapper;

import com.renguangli.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * EmployeeMapper
 *
 * @author renguangli 2018/9/26 11:07
 * @since JDK 1.8
 */
public interface EmployeeMapper extends BaseMapper<Employee, Integer>{

    List<Employee> listEmployees(@Param("pojo") Employee employee,
                                 @Param("page") Integer page,
                                 @Param("size") Integer size);

    Long countEmployee(@Param("pojo") Employee employee);
}
