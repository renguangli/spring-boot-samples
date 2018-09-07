package com.renguangli.exceptionValidation;

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
        限制	说明
        @Null	限制只能为null
        @NotNull	限制必须不为null
        @AssertFalse	限制必须为false
        @AssertTrue	限制必须为true
        @DecimalMax(value)	限制必须为一个不大于指定值的数字
        @DecimalMin(value)	限制必须为一个不小于指定值的数字
        @Digits(integer,fraction)	限制必须为一个小数，且整数部分的位数不能超过integer，小数部分的位数不能超过fraction
        @Future	限制必须是一个将来的日期
        @Max(value)	限制必须为一个不大于指定值的数字
        @Min(value)	限制必须为一个不小于指定值的数字
        @Past	限制必须是一个过去的日期
        @Pattern(value)	限制必须符合指定的正则表达式
        @Size(max,min)	限制字符长度必须在min到max之间
        @Past	验证注解的元素值（日期类型）比当前时间早
        @NotEmpty	验证注解的元素值不为null且不为空（字符串长度不为0、集合大小不为0）
        @NotBlank	验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格
        @Email	验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式

     */
    private int userId;

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
                ", username=" + username +
                ", password=" + password +
                ", age=" + age +
                ", email=" + email +
                ", telNo=" + telNo +
                ", birthday=" + birthday +
                "}";
    }
}
