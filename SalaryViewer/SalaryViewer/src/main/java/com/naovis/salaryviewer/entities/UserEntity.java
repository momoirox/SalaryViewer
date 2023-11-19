package com.naovis.salaryviewer.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "ApplicationUser")
@Data
public class UserEntity extends EntityBase {
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
    @EqualsAndHashCode.Exclude
    private List<RoleEntity> roles;
}
