package com.salaryviewer.core.repositories;

import com.salaryviewer.core.models.RoleModel;

import java.util.ArrayList;
import java.util.List;

public interface RoleRepository {
    List<RoleModel> findAllById(ArrayList<Long> rolesId);

    List<RoleModel> getForUser(Long userId);

    List<RoleModel> findAll();

    RoleModel get(Long id);

    RoleModel save(RoleModel role);

    void delete(Long id);
}
