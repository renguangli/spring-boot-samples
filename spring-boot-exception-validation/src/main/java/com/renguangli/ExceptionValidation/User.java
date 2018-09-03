package com.renguangli.ExceptionValidation;

import java.time.LocalDateTime;

/**
 * User
 *
 * @author renguangli 2018/8/31 17:12
 * @since JDK 1.8
 */
public class User {

    private Integer userId;

    private String name;

    private Integer age;

    private LocalDateTime birthday;

    private boolean disabled;

    public User(){}

    public User(Integer userId, String name, Integer age, LocalDateTime birthday, boolean disabled) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.disabled = disabled;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name=" + name +
                ", age=" + age +
                ", birthday=" + birthday +
                ", disabled=" + disabled +
                "}";
    }

}
