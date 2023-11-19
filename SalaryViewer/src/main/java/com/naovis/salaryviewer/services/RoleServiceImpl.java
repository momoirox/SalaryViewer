package com.naovis.salaryviewer.services;

import com.naovis.salaryviewer.converters.Converter;
import com.naovis.salaryviewer.entities.RoleEntity;
import com.naovis.salaryviewer.models.RoleModel;
import com.naovis.salaryviewer.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepo;
    private final Converter<RoleEntity, RoleModel> roleConverter;

    @Override
    public List<RoleModel> getAll() {
        List<RoleEntity> entities = roleRepo.findAll();
        return roleConverter.convert(entities);
    }

    @Override
    public RoleModel get(Long id) {
        RoleEntity entity = roleRepo.getById(id);
        return roleConverter.convert(entity);
    }

    @Override
    public Long save(RoleModel role) {
        RoleEntity entity = roleConverter.convert(role);
        roleRepo.save(entity);
        return entity.getId();
    }

    @Override
    public void delete(Long id) {
        roleRepo.deleteById(id);
    }

    @Override
    public Long save(RoleModel role, Long id) {
        role.setId(role.getId());
        RoleEntity newEntity = roleConverter.convert(role);
        roleRepo.save(newEntity);
        return newEntity.getId();
    }

}
