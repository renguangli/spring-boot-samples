package com.renguangli.ExceptionValidation;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * User
 *
 * @author renguangli 2018/8/31 17:12
 * @since JDK 1.8
 */
public class User {

    /*
        @AssertFalse 校验false
        @AssertTrue 校验true
        @DecimalMax(value=,inclusive=) 小于等于value，
        inclusive=true,是小于等于
        @DecimalMin(value=,inclusive=) 与上类似
        @Max(value=) 小于等于value
        @Min(value=) 大于等于value
        @NotNull  检查Null
        @Past  检查日期
        @Pattern(regex=,flag=)  正则
        @Size(min=, max=)  字符串，集合，map限制大小
        @Valid 对po实体类进行校验

     */

    @NotNull(message = "用户ID不能为null！")
    private Integer userId;

    @Length(min = 6, max = 16, message = "用户名长度必须在6至16之间！")
    private String username;

    @Length(min = 8, max = 16, message = "密码长度必须在8至16之间！")
    private String password;

    private int age;

    @Email(message = "邮箱格式不正确！")
    private String email;

    @Pattern(regexp = "^\\d{11}$", message = "手机格式不正确！")
    private String telNo;

    private LocalDateTime birthday;

    public User(){}

    @NotNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", telNo='" + telNo + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
