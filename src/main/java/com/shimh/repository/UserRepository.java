package com.shimh.repository;

import com.shimh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    //Long findOneByAccount(String account);
    User findByAccount(String account);
}
