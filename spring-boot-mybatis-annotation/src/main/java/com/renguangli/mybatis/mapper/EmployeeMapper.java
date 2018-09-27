package com.renguangli.mybatis.mapper;

import com.renguangli.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * EmployeeMapper
 *
 * @author renguangli 2018/9/26 11:07
 * @since JDK 1.8
 */
public interface EmployeeMapper {

    @SelectProvider(type = EmployeeProvider.class, method = "listEmployees")
    List<Employee> listEmployees(Employee employee, Integer page, Integer size);

    @SelectProvider(type = EmployeeProvider.class, method = "countEmployees")
    int countEmployees(Employee employee);

    @Insert("select * from employee emp_no = #{param1}")
    int saveEmployee(@Param("pojo")Employee employee);

    @Select("select * from employee where emp_no = #{param1}")
    Employee getEmployee(Integer empNo);

    @Delete("delete from employee where emp_no = #{empNo}")
    int deleteEmployee(@Param("empNo") Integer empNo);

    @Update("update employee set last_name = #{pojo.lastName} where emp_no = #{pojo.empNo}")
    int updateEmployee(@Param("pojo") Employee employee);
}
