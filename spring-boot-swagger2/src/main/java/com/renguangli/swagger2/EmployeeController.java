package com.renguangli.swagger2;

import io.swagger.annotations.Api;
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
@Api(value = "雇员相关操作")
@RestController
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeController(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }


    @ApiOperation(value="获取单个雇员信息", tags = {"获取单个雇员信息"}, notes="根据url的id来获取雇员信息")
    @ApiImplicitParam(name = "id", value = "雇员id", required = true, dataType = "int", paramType = "path")
    @GetMapping("/employee/{id}")
    public Employee user(@PathVariable Integer id) {
        return employeeMapper.get(id);
    }

    @ApiOperation(value="获取全部雇员信息", tags = {"获取全部雇员信息"}, notes="获取全部雇员信息")
    @GetMapping("/employees")
    public List<Employee> employees() {
        List<Employee> all = employeeMapper.listEmployee();
        return all;
    }
}
