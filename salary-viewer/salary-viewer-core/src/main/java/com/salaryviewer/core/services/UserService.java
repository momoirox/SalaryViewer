package com.salaryviewer.core.services;

import com.salaryviewer.core.models.UserModel;

import java.util.List;


public interface UserService {

    /**
     * Gets user by id form database
     *
     * @param id user id
     * @return user model
     */
    UserModel get(Long id);

    /**
     * Updates user if it exists in database
     *
     * @param user user model
     */
    void save(UserModel user);

    /**
     * Deletes user by id form database
     *
     * @param id user id
     */
    void delete(Long id);

    /**
     * @return all users from database
     */
    List<UserModel> getAll();
}
