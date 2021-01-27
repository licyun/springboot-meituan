package com.licyun.meituan.food.repository;

import com.licyun.meituan.food.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select user from User user where user.userId = ?1 ")
    public User mySql(int id);

    public User findByUserId(Integer userId);

    public User findByUserEmail(String userEmail);

}
