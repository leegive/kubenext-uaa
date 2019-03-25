package com.kubenext.uaa.demo.dto;


import com.fasterxml.jackson.annotation.JsonView;
import com.kubenext.uaa.demo.validator.MyConstraint;

import javax.validation.constraints.NotBlank;

public class User {

    public interface UserSimpleView {}
    public interface UserDetailView extends UserSimpleView {}

    @JsonView(UserSimpleView.class)
    private String id;

    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "这是一个测试")
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
