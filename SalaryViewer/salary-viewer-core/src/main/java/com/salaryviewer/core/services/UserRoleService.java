package com.salaryviewer.core.services;

import com.salaryviewer.core.models.RoleModel;
import java.util.ArrayList;
import java.util.List;

public interface UserRoleService {
    /**
     * Sets the roles for the specified user
     *
     * @param userId  specified user
     * @param rolesId list of roles
     */
    void set(Long userId, ArrayList<Long> rolesId);

    /**
     * Returns roles that user has
     *
     * @param userId specified user
     * @return list of roles
     */
    List<RoleModel> get(Long userId);
}
