package com.naovis.salaryviewer.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Role")
@Data
public class RoleEntity extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Descroption")
    private String description;

    @ManyToMany(mappedBy = "roles")
    @EqualsAndHashCode.Exclude
    private List<UserEntity> entities;
}
