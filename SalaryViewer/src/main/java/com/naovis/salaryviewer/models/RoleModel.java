package com.naovis.salaryviewer.models;

import lombok.Data;

import java.util.List;

@Data
public class RoleModel extends Model {

    private Long id;
    private String name;
    private String description;
    private List<UserModel> entities;

}
