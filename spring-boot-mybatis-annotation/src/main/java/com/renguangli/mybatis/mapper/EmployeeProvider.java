package com.renguangli.mybatis.mapper;

import com.renguangli.mybatis.bean.Employee;

/**
 * EmployeeProvider
 *
 * @author renguangli 2018/9/27 17:26
 * @since JDK 1.8
 */
public class EmployeeProvider {

    public String listEmployees(Employee employee,int page, int size) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from employee where 1=1 ");
        String firsName = employee.getFirstName();
        if (firsName != null && !"".equals(firsName)) {
            sql.append("and first_name = #{param1.firstName} ");
        }

        String lastName = employee.getLastName();
        if (lastName != null && !"".equals(lastName)) {
            sql.append("and last_name = #{param1.lastName} ");
        }

        sql.append("limit #{param2},#{param3}");
        return sql.toString();
    }

    public String countEmployees(Employee employee) {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*) from employee where 1=1 ");
        String firsName = employee.getFirstName();
        if (firsName != null && !"".equals(firsName)) {
            sql.append("and first_name = #{param1.firstName} ");
        }

        String lastName = employee.getLastName();
        if (lastName != null && !"".equals(lastName)) {
            sql.append("and last_name = #{param1.lastName} ");
        }
        return sql.toString();
    }
}
