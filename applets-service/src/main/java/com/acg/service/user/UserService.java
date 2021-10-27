package com.acg.service.user;

import com.acg.entity.user.MyUser;

public interface UserService {
    MyUser findUserByName(String username);
}
