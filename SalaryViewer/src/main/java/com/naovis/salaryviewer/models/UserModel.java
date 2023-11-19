package com.naovis.salaryviewer.models;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
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
