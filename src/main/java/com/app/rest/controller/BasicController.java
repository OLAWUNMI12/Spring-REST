package com.app.rest.controller;

import com.app.rest.dto.UserDTO;
import com.app.rest.model.request.UserRequest;
import com.app.rest.model.response.UserResponse;
import com.app.rest.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class BasicController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    public String fetchUser(){
        return "Fetching user";
    }

    @PutMapping("/update")
    public String updateUser(){
        return "Updating User";
    }

    @PostMapping("/create")
    public UserResponse CreateUser(@RequestBody UserRequest userRequest){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userRequest, userDTO);

        UserDTO userDTOResponse = userService.createUser(userDTO);
        UserResponse userResponse = new UserResponse();

        BeanUtils.copyProperties(userDTOResponse, userResponse);
        return userResponse;
    }

    @DeleteMapping("/delete")
    public String deleteUser(){
        return "deleting user";
    }
}
