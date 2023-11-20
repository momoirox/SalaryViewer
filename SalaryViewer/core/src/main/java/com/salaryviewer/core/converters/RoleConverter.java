package com.salaryviewer.core.converters;

import com.salaryviewer.core.entities.RoleEntity;
import org.springframework.stereotype.Component;

import com.salaryviewer.core.models.RoleModel;
import java.util.ArrayList;
import java.util.List;


@Component
public class RoleConverter implements Converter<RoleEntity, RoleModel> {
    @Override
    public RoleModel convert(RoleEntity entity) {
        RoleModel role = new RoleModel();
        role.setId(entity.getId());
        role.setName(entity.getName());
        role.setDescription(entity.getDescription());

        return role;
    }

    @Override
    public RoleEntity convert(RoleModel role) {
        RoleEntity entity = new RoleEntity();
        entity.setId(role.getId());
        entity.setName(role.getName());
        entity.setDescription(role.getDescription());

        return entity;
    }

    @Override
    public List<RoleModel> convert(List<RoleEntity> roles) {
        List<RoleModel> roleModels = new ArrayList<>();
        for (RoleEntity r : roles) {
            roleModels.add(convert(r));
        }
        return roleModels;
    }


}
