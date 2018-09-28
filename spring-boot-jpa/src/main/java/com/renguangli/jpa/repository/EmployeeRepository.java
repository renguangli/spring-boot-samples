package com.renguangli.jpa.repository;

import com.renguangli.jpa.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * EmployeeRepository
 *
 * @author renguangli 2018/9/28 10:06
 * @since JDK 1.8
 */
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


    @Modifying
    @Query("update Employee set firstName = ?2 where empNo = ?1")
    Integer updateEmployee(Integer empNo, String firstName);

    Page<Employee> findAll(Specification<Employee> spec, Pageable pageable);
}
