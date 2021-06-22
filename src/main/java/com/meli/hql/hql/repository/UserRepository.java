package com.meli.hql.hql.repository;

import com.meli.hql.hql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Modifying
//    @Query(value = "insert into users (username, password) values (:user.username, :user.password)", nativeQuery = true)
//    @Transactional
//    void createUser(User user);

    @Query(value = "select * from user u where u.id = :id", nativeQuery = true)
    User getUserById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update user u set u.password = :newPassword where u.id = :id", nativeQuery = true)
    void updateUserPassword(@Param("id") int id, @Param("newPassword") String newPassword);

    @Modifying
    @Transactional
    @Query(value = "delete from user u where u.id = :id", nativeQuery = true)
    void deleteUserById(@Param("id") int id);
}
