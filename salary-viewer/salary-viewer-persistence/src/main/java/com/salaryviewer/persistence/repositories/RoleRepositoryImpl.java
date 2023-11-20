package com.salaryviewer.persistence.repositories;

import com.salaryviewer.core.models.RoleModel;
import com.salaryviewer.core.repositories.RoleRepository;
import com.salaryviewer.persistence.converters.Converter;
import com.salaryviewer.persistence.entities.RoleEntity;
import com.salaryviewer.persistence.jparepositories.RoleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {
    private final Converter<RoleEntity, RoleModel> roleConverter;
    private final RoleJpaRepository repository;

    @Override
    public List<RoleModel> findAllById(ArrayList<Long> rolesId) {
        List<RoleEntity> roleEntities = repository.findAllById(rolesId);
        return roleConverter.convert(roleEntities);
    }

    @Override
    public List<RoleModel> getForUser(Long userId) {
        List<RoleEntity> userRoles = repository.getForUser(userId);
        return roleConverter.convert(userRoles);
    }

    @Override
    public List<RoleModel> findAll() {
        return roleConverter.convert(repository.findAll());
    }

    @Override
    public RoleModel get(Long id) {
        RoleEntity role = repository.getReferenceById(id);
        return roleConverter.convert(role);
    }

    @Override
    public RoleModel save(RoleModel role) {
        RoleEntity roleEntity = roleConverter.convert(role);
        RoleEntity savedRole = repository.save(roleEntity);
        return roleConverter.convert(savedRole);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
