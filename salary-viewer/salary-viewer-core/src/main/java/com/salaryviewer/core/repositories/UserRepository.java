package com.salaryviewer.core.repositories;

import com.salaryviewer.core.models.UserModel;

import java.util.List;

public interface UserRepository {
    UserModel getReferenceById(Long userId);

    UserModel save(UserModel userModel);

    void delete(Long id);

    List<UserModel> findAll();
}
