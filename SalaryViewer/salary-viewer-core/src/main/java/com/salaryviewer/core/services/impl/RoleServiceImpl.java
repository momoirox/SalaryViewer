package com.salaryviewer.core.services.impl;

import com.salaryviewer.core.services.RoleService;
import com.salaryviewer.core.entities.RoleEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.salaryviewer.core.converters.Converter;
import com.salaryviewer.core.models.RoleModel;
import com.salaryviewer.core.repositories.RoleRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final Converter<RoleEntity, RoleModel> roleConverter;

    @Override
    public List<RoleModel> getAll() {
        List<RoleEntity> entities = roleRepository.findAll();
        return roleConverter.convert(entities);
    }

    @Override
    public RoleModel get(Long id) {
        RoleEntity entity = roleRepository.getReferenceById(id);
        return roleConverter.convert(entity);
    }

    @Override
    public Long save(RoleModel role) {
        RoleEntity entity = roleConverter.convert(role);
        roleRepository.save(entity);
        return entity.getId();
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Long save(RoleModel role, Long id) {
        role.setId(role.getId());
        RoleEntity newEntity = roleConverter.convert(role);
        roleRepository.save(newEntity);
        return newEntity.getId();
    }
}
