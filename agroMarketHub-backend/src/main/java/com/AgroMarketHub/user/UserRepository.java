package com.AgroMarketHub.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserName(String username);

//    @Query(value = "SELECT u.userName AS user_name, r.name AS role_name " +
//            "FROM UserEntity u " +
//            "JOIN user_role ur ON u.id = ur.user.id " +
//            "JOIN Role r ON ur.role.id = r.id " +
//            "WHERE u.userName = :userName")
//    List<Object[]> findUserAndRoleByUsername(@Param("userName") String userName);

}
