package com.naovis.salaryviewer.services;

import com.naovis.salaryviewer.converters.Converter;
import com.naovis.salaryviewer.entities.RoleEntity;
import com.naovis.salaryviewer.entities.UserEntity;
import com.naovis.salaryviewer.models.RoleModel;
import com.naovis.salaryviewer.repositories.RoleRepository;
import com.naovis.salaryviewer.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
