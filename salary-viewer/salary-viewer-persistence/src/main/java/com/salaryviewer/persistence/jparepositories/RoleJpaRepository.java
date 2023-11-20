package com.salaryviewer.persistence.jparepositories;

import com.salaryviewer.persistence.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleJpaRepository extends JpaRepository<RoleEntity, Long> {

    @Query("select e.roles " +
            "from UserEntity e " +
            "where e.id = :userId")
    List<RoleEntity> getForUser(@Param("userId") Long userId);
}
