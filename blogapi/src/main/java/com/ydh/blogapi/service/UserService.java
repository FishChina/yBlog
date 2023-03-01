package com.ydh.blogapi.service;

import com.ydh.blogapi.po.User;

/**

 */
public interface UserService {

    User checkUser(String username, String password);
}
