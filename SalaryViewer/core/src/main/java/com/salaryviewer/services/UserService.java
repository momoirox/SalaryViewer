package com.salaryviewer.services;

import com.salaryviewer.models.UserModel;

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
    Long save(UserModel user);

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

    /**
     * Creates new user in database
     *
     * @param data user data model for creating user
     * @param id   user id
     * @return
     */
    Long save(UserModel data, Long id);
}
