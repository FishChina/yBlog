package com.ydh.blogapi.service;

import com.ydh.blogapi.dao.UserRepository;
import com.ydh.blogapi.po.User;
import com.ydh.blogapi.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**

 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
