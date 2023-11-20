package com.salaryviewer.rest.controllers;

import com.salaryviewer.core.models.RoleModel;
import com.salaryviewer.core.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<RoleModel> getAll() {
        return roleService.getAll();
    }

    @GetMapping("{id}")
    public RoleModel get(@PathVariable Long id) {
        return roleService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleModel save(@RequestBody RoleModel newRole) {
        return roleService.save(newRole);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }
}
