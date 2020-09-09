package com.ssm.dao;

import com.ssm.model.User;

public interface UserDao {

 User findByUsername(String username);
}
