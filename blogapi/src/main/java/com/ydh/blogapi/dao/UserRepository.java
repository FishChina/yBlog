package com.ydh.blogapi.dao;

import com.ydh.blogapi.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**

 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);
}
