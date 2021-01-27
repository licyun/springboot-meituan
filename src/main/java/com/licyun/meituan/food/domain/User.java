package com.licyun.meituan.food.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;

    @Email(message = "邮箱格式不正确")
    @Column(name = "user_email", unique = true,
            columnDefinition = " varchar(100) comment '用户邮箱' ")
    private String userEmail;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 5, max = 12, message = "用户名长度必须在5到12个字符")
    @Column(name="user_name",
            columnDefinition = " varchar(100) comment '用户名' ")
    private String userName;

    @NotBlank(message = "用户密码不能为空")
    @Length(min = 6, max = 12, message = "密码长度必须在6到12个字符")
    @Column(name="user_pass",
            columnDefinition = " varchar(100) comment '用户密码' ")
    private String userPass;

    @Column(name = "user_role",
            columnDefinition=" int(11) default 1 comment '用户权限' ")
    private Integer userRole;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
