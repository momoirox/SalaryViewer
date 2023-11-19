package com.salaryviewer.services.impl;

import com.salaryviewer.entities.RoleEntity;
import com.salaryviewer.entities.UserEntity;
import com.salaryviewer.models.RoleModel;
import com.salaryviewer.services.UserRoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.salaryviewer.converters.Converter;
import com.salaryviewer.repositories.RoleRepository;
import com.salaryviewer.repositories.UserRepository;

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
