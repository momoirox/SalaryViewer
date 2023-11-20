package com.salaryviewer.core.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "ApplicationUser")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "ValidFrom")
    private Date validFrom;

    @Column(name = "ValidTo")
    private Date validTo;

    @ManyToMany
    @JoinTable(
            name = "RelationUserRole",
            joinColumns = @JoinColumn(name = "RefUser"),
            inverseJoinColumns = @JoinColumn(name = "RefRole")
    )
    private List<RoleEntity> roles;
}
