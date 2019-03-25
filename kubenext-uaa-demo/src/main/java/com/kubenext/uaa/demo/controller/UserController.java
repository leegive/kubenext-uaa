package com.kubenext.uaa.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kubenext.uaa.demo.dto.User;
import com.kubenext.uaa.demo.dto.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lishangjin
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody User user) {
        System.out.println(user);
        user.setId("1");
        return user;
    }

    @PutMapping("{id:\\d+}")
    @JsonView(User.UserSimpleView.class)
    public User update(@PathVariable String id, @Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                String msg = fieldError.getField() +  " " + fieldError.getDefaultMessage();
                System.out.println(msg);
            });
        }

        System.out.println(user);
        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition userQueryCondition, @PageableDefault Pageable pageable){
        System.out.println(userQueryCondition.toString());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @DeleteMapping("{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

}
