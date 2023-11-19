package com.naovis.salaryviewer.services.impl;

import com.naovis.salaryviewer.converters.Converter;
import com.naovis.salaryviewer.entities.RoleEntity;
import com.naovis.salaryviewer.models.RoleModel;
import com.naovis.salaryviewer.repositories.RoleRepository;
import com.naovis.salaryviewer.services.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
