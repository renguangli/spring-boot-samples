package com.renguangli.shiro;

import java.time.LocalDateTime;

/*
 *
 * Created by renguangli at 2018/10/13 19:47
 * @since JDK1.8
 */
public class User {

    private Long userId;

    private String username;

    private String password;

    private LocalDateTime createTime;

    private User(){}

    public User(Long userId, String username, String password, LocalDateTime createTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                '}';
    }

}
