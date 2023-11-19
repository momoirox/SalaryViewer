package com.salaryviewer.controllers;

import com.salaryviewer.models.UserModel;
import com.salaryviewer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserModel> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public UserModel get(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel save(@RequestBody UserModel newUser) {
        Long id = userService.save(newUser);
        return userService.get(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("{id}")
    public UserModel save(@PathVariable Long id, @RequestBody UserModel user) {
        userService.save(user, id);
        return userService.get(id);
    }

}
