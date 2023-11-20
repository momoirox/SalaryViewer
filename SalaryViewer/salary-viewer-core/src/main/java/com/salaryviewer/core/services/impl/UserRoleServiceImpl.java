package com.salaryviewer.core.services.impl;

import com.salaryviewer.core.services.UserRoleService;
import com.salaryviewer.core.entities.RoleEntity;
import com.salaryviewer.core.entities.UserEntity;
import com.salaryviewer.core.models.RoleModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.salaryviewer.core.converters.Converter;
import com.salaryviewer.core.repositories.RoleRepository;
import com.salaryviewer.core.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final Converter<RoleEntity, RoleModel> roleConverter;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void set(Long userId, ArrayList<Long> rolesId) {
        List<RoleEntity> roleEntities = roleRepository.findAllById(rolesId);
        UserEntity userEntity = userRepository.getReferenceById(userId);
        userEntity.setRoles(roleEntities);
        userRepository.save(userEntity);

    }

    @Override
    public List<RoleModel> get(Long userId) {
        List<RoleEntity> roles = roleRepository.getAll(userId);
        List<RoleModel> roleModels = roleConverter.convert(roles);

        return roleModels;
    }
}
