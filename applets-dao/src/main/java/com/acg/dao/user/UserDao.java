package com.acg.dao.user;

import com.acg.entity.user.MyUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    MyUser findUserByName(String username);
}
