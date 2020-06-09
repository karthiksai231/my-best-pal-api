package com.core.mybestpalapi.controller;

import com.core.mybestpalapi.common.controller.AbstractController;
import com.core.mybestpalapi.dto.UserDto;
import com.core.mybestpalapi.persistence.model.User;
import com.core.mybestpalapi.service.IUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
@AllArgsConstructor
@Tag(name = "user", description = "the User API")
public class UserController extends AbstractController<User> {

    private IUserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid final UserDto userDto) {
        createInternal(getUserToCreate(userDto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User get(@PathVariable(name = "id") final String id) {
        return getByIdInternal(id);
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
