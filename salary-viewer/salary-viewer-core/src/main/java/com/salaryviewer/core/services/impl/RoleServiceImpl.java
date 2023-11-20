package com.salaryviewer.core.services.impl;

import com.salaryviewer.core.models.RoleModel;
import com.salaryviewer.core.repositories.RoleRepository;
import com.salaryviewer.core.services.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<RoleModel> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleModel get(Long id) {
        return roleRepository.get(id);
    }

    @Override
    public RoleModel save(RoleModel role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.delete(id);
    }
}
