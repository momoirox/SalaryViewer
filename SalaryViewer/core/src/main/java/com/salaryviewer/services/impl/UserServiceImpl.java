package com.salaryviewer.services.impl;

import com.salaryviewer.entities.UserEntity;
import com.salaryviewer.models.UserModel;
import com.salaryviewer.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.salaryviewer.converters.Converter;
import com.salaryviewer.repositories.UserRepository;

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














