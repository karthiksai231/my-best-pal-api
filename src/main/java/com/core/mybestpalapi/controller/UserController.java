package com.core.mybestpalapi.controller;

import com.core.mybestpalapi.common.controller.AbstractController;
import com.core.mybestpalapi.dto.UserDto;
import com.core.mybestpalapi.persistence.model.User;
import com.core.mybestpalapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController extends AbstractController<User> {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final UserDto userDto) {
        createInternal(getUserToCreate(userDto));
    }

    private User getUserToCreate(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .userName(userDto.getUserName())
                .build();
    }

    @Override
    protected IUserService getService() {
        return userService;
    }
}