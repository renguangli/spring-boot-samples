package com.renguangli.jpa.controller;

import com.renguangli.jpa.Result;
import com.renguangli.jpa.entity.Employee;
import com.renguangli.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public Result listEmployees(Employee employee,
                                @RequestParam(name = "page", defaultValue = "1") Integer page,
                                @RequestParam(name = "size", defaultValue = "10") Integer size) {
        // 动态sql查询
        Specification<Employee> specification = (root, query, cb) -> {
            List<Predicate> list = new ArrayList<Predicate>();
            if (employee.getFirstName() != null && !"".equals(employee.getFirstName())){
                list.add(cb.like(root.get("firstName").as(String.class), employee.getFirstName() + "%"));
            }
            return cb.and(list.toArray(new Predicate[0]));
        };
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<Employee> pageEmployee = employeeRepository.findAll(specification,pageRequest);
        return new Result(pageEmployee.getContent(), pageEmployee.getTotalElements(), page, size);
    }

    @GetMapping("/employee/{empNo}")
    public Employee getEmployee(@PathVariable("empNo") Integer empNo) {
        Employee employee = employeeRepository.findOne(empNo);
        return employee;
    }

    @PostMapping("/employee")
    public Employee saveEmployee(Employee employee) {
        employee.setBirthDate(new Date());
        employee.setHireDate(new Date());
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employee/{empNo}")
    public int deleteEmployee(@PathVariable("empNo") Integer empNo) {
        employeeRepository.delete(empNo);
        return 1;
    }

    @PutMapping("/employee")
    public Integer updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee.getEmpNo(), employee.getFirstName());
    }

    @GetMapping("")
    public String index() {
        return "index";
    }
    
}
