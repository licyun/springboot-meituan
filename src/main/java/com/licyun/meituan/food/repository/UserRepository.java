package com.licyun.meituan.food.repository;

import com.licyun.meituan.food.domain.User;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select user from User user where user.userId = ?1 ")
    User mySql(int id);

    User findByUserId(Integer userId);

    User findByUserEmail(String userEmail);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    void deleteByUserId(Integer userId);

}
