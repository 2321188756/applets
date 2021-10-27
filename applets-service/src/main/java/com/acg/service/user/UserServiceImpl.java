package com.acg.service.user;

import com.acg.dao.user.UserDao;
import com.acg.entity.user.MyUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override
    public MyUser findUserByName(String username) {
        return userDao.findUserByName(username);
    }
}
