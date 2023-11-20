package com.salaryviewer.core.services.impl;

import com.salaryviewer.core.models.RoleModel;
import com.salaryviewer.core.models.UserModel;
import com.salaryviewer.core.repositories.RoleRepository;
import com.salaryviewer.core.repositories.UserRepository;
import com.salaryviewer.core.services.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void set(Long userId, ArrayList<Long> rolesId) {
        List<RoleModel> roles = roleRepository.findAllById(rolesId);
        UserModel userModel = userRepository.getReferenceById(userId);
        userModel.setRoles(roles);
        userRepository.save(userModel);
    }

    @Override
    public List<RoleModel> get(Long userId) {
        return roleRepository.getForUser(userId);
    }
}
