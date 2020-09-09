package com.ssm.service;

import com.ssm.model.User;

public interface UserService {
    User checkLogin(String username, String password);
}
