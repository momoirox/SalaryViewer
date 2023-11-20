package com.salaryviewer.core.services;

import com.salaryviewer.core.models.RoleModel;

import java.util.List;


public interface RoleService {

    /**
     * Gets role by Id from database.
     *
     * @param id role id
     * @return role model
     */
    RoleModel get(Long id);

    /**
     * Updates role if it exists in database
     *
     * @param role data model for updating role
     */
    RoleModel save(RoleModel role);

    /**
     * Deletes role by Id from database.
     *
     * @param id role id
     */
    void delete(Long id);


    /**
     * @return Returns all roles form database.
     */
    List<RoleModel> getAll();
}
