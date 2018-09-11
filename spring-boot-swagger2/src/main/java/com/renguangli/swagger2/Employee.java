package com.renguangli.swagger2;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Employee
 *
 * @author renguangli 2018/9/11 17:12
 * @since JDK 1.8
 */
public class Employee implements Serializable {

    private Integer empNo;

    private String firstName;

    private String lastName;

    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer id) {
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                "}";
    }
}
