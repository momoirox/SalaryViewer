package com.naovis.salaryviewer.repositories;

import com.naovis.salaryviewer.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("from UserEntity ue " +
            "where ue.username = :username")
    UserEntity find(String username);
}
