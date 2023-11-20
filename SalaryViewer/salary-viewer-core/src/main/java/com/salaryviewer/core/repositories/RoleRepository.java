package com.salaryviewer.core.repositories;

import com.salaryviewer.core.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query(value = "SELECT *" +
            "FROM dbo.RelationUserRole rur LEFT JOIN dbo.Role r ON rur.RefRole = r.Id " +
            "WHERE rur.RefUser = :userId",
            nativeQuery = true)
    List<RoleEntity> getAll(@Param("userId") Long userId);

}
