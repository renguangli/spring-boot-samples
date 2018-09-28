package com.renguangli.mybatis.mapper;

import com.renguangli.mybatis.bean.Employee;

import java.util.Map;

/**
 * EmployeeProvider
 *
 * @author renguangli 2018/9/27 17:26
 * @since JDK 1.8
 */
public class EmployeeProvider {

    public String listEmployees(Map<String, Object> params) {
        Employee employee = (Employee) params.get("pojo");
        StringBuilder sql = new StringBuilder();
        sql.append("select * from employee where 1=1 ");

        String firsName = employee.getFirstName();
        if (firsName != null && !"".equals(firsName)) {
            sql.append("and first_name = #{pojo.firstName} ");
        }

        String lastName = employee.getLastName();
        if (lastName != null && !"".equals(lastName)) {
            sql.append("and last_name = #{pojo.lastName} ");
        }

        sql.append("limit #{page},#{size}");
        return sql.toString();
    }

    public String countEmployees(Map<String, Object> params) {
        Employee employee = (Employee) params.get("pojo");
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*) from employee where 1=1 ");

        String firsName = employee.getFirstName();
        if (firsName != null && !"".equals(firsName)) {
            sql.append("and first_name = #{pojo.firstName} ");
        }

        String lastName = employee.getLastName();
        if (lastName != null && !"".equals(lastName)) {
            sql.append("and last_name = #{pojo.lastName} ");
        }
        return sql.toString();
    }
}
