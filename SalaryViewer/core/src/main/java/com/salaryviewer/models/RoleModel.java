package com.salaryviewer.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleModel extends Model {
    private Long id;
    private String name;
    private String description;
    private List<UserModel> entities;
}
