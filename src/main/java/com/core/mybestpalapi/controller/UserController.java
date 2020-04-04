package com.core.mybestpalapi.controller;

import com.core.mybestpalapi.common.controller.AbstractController;
import com.core.mybestpalapi.dto.UserDto;
import com.core.mybestpalapi.persistence.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractController<User> {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final UserDto userDto) {

    }

    private User getUserToCreate(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .userName(userDto.getUserName())
                .build();
    }
}
