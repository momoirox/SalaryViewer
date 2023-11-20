package com.salaryviewer.core.services.impl;

import com.salaryviewer.core.models.UserModel;
import com.salaryviewer.core.repositories.UserRepository;
import com.salaryviewer.core.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserModel get(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public void save(UserModel user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }
}














