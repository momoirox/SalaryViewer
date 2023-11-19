package com.salaryviewer.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class UserModel extends Model {
    private Long id;
    private Boolean isActive;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Date validFrom;
    private Date validTo;
    private List<RoleModel> roles;
}
