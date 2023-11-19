package com.naovis.salaryviewer.repositories;

import com.naovis.salaryviewer.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query(value = "SELECT *" +
            "FROM dbo.RelationUserRole rur LEFT JOIN dbo.Role r ON rur.RefRole = r.Id \n" +
            "WHERE rur.RefUser =:userId\n",nativeQuery = true)
    List<RoleEntity> getAll(@Param("userId") Long userId);

}
