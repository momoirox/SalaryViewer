package com.salaryviewer.persistence.repositories;

import com.salaryviewer.core.models.UserModel;
import com.salaryviewer.core.repositories.UserRepository;
import com.salaryviewer.persistence.converters.Converter;
import com.salaryviewer.persistence.entities.UserEntity;
import com.salaryviewer.persistence.jparepositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final Converter<UserEntity, UserModel> converter;
    private final UserJpaRepository repository;


    @Override
    public UserModel getReferenceById(Long userId) {
        UserEntity user = repository.getReferenceById(userId);
        return converter.convert(user);
    }

    @Override
    public UserModel save(UserModel userModel) {
        UserEntity entity = converter.convert(userModel);
        UserEntity savedUser = repository.save(entity);
        return converter.convert(savedUser);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserModel> findAll() {
        List<UserEntity> userEntities = repository.findAll();
        return converter.convert(userEntities);
    }
}
