package com.renguangli.swagger2;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *
 * Created by renguangli at 2018/9/1 13:31
 * @since JDK1.8
 */
@RestController
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeController(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }


    @ApiOperation(value="获取雇员信息", notes="根据url的id来获取雇员信息")
    @ApiImplicitParam(name = "id", value = "雇员id", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/employee/{id}")
    public Employee user(@PathVariable Integer id) {
        return employeeMapper.get(id);
    }

    @GetMapping("/employees")
    public List<Employee> employees() {
        List<Employee> all = employeeMapper.listEmployee();
        return all;
    }
}
