package com.salaryviewer.core.converters;

import com.salaryviewer.core.entities.UserEntity;
import com.salaryviewer.core.models.UserModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter implements Converter<UserEntity, UserModel> {

    @Override
    public UserEntity convert(UserModel user) {
        UserEntity entity = new UserEntity();

        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setIsActive(user.getIsActive());
        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setValidFrom(user.getValidFrom());
        entity.setValidTo(user.getValidTo());
        return entity;
    }

    @Override
    public List<UserModel> convert(List<UserEntity> entities) {
        List<UserModel> users = new ArrayList<>();

        for(UserEntity e : entities){
            users.add(convert(e));
        }
        return users;
    }

    @Override
    public UserModel convert(UserEntity entity) {
        UserModel userDto = new UserModel();

        userDto.setId(entity.getId());
        userDto.setUsername(entity.getUsername());
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setEmail(entity.getEmail());
        userDto.setIsActive(entity.getIsActive());
        userDto.setPassword(entity.getPassword());
        userDto.setValidFrom(entity.getValidFrom());
        userDto.setValidTo(entity.getValidTo());
        return userDto;
    }


}
