package com.renguangli.swagger2;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * EmployeeMapper
 *
 * @author renguangli 2018/9/11 17:12
 * @since JDK 1.8
 */
public interface EmployeeMapper {

    @Select("select * from employee where emp_no = #{param1}")
    Employee get(Integer empNo);

    @Select("select * from employee")
    List<Employee> listEmployee();
}
