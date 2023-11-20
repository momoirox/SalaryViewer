package com.salaryviewer.core.services.impl;

import com.salaryviewer.core.services.UserService;
import com.salaryviewer.core.entities.UserEntity;
import com.salaryviewer.core.models.UserModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.salaryviewer.core.converters.Converter;
import com.salaryviewer.core.repositories.UserRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository usersRepo;
    private final Converter<UserEntity, UserModel> userConverter;

    @Override
    public UserModel get(Long id) {
        UserEntity userEntity = usersRepo.getReferenceById(id);
        return userConverter.convert(userEntity);
    }

    @Override
    public Long save(UserModel user, Long id) {

        user.setId(id);
        UserEntity entity = userConverter.convert(user);
        usersRepo.save(entity);
        return entity.getId();

    }

    @Override
    public void delete(Long id) {
        usersRepo.deleteById(id);
    }

    @Override
    public List<UserModel> getAll() {
        List<UserEntity> entities = usersRepo.findAll();
        return userConverter.convert(entities);
    }

    @Override
    public Long save(UserModel user) {

        UserEntity newEntity = userConverter.convert(user);
        usersRepo.save(newEntity);
        return newEntity.getId();

    }
}














