package com.licyun.meituan.food.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "mt_user")
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

}
