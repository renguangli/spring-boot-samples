package com.renguangli.mybatis.controller;

import com.renguangli.mybatis.Result;
import com.renguangli.mybatis.bean.Employee;
import com.renguangli.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * EmployeeController
 *
 * @author renguangli 2018/9/26 11:05
 * @since JDK 1.8
 */
@RestController
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeController(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/employees")
    public Result listEmployees(Employee employee,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "10") Integer size) {
        int offset = (page - 1) * size;
        List<Employee> employees = employeeMapper.listEmployees(employee, offset, size);
        long count = employeeMapper.countEmployees(employee);
        return new Result(employees, count, page, size);
    }

    @GetMapping("/employee/{empNo}")
    public Employee getEmployee(@PathVariable("empNo") Integer empNo) {
        Employee employee = employeeMapper.getEmployee(empNo);
        System.out.println(employee);
        return employee;
    }

    @PostMapping("/employee")
    public int saveEmployee(Employee employee) {
        employee.setBirthDate(new Date());
        employee.setHireDate(new Date());
        return employeeMapper.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{empNo}")
    public int deleteEmployee(@PathVariable("empNo") Integer empNo) {
        return employeeMapper.deleteEmployee(empNo);
    }

    @PutMapping("/employee")
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @GetMapping("")
    public String index() {
        return "index";
    }
    
}
