package com.salaryviewer.controllers;

import com.salaryviewer.models.RoleModel;
import com.salaryviewer.services.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users/roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @GetMapping(path = "/{id}")
    public List<RoleModel> get(@PathVariable Long id) {
        return userRoleService.get(id);
    }

    @PutMapping(path = "/{id}")
    public void set(@PathVariable(name = "id") Long userId, @RequestBody ArrayList<Long> rolesId) {

        userRoleService.set(userId, rolesId);

    }
}
