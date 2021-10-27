package com.acg.auth;

import com.acg.entity.user.MyUser;
import com.acg.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
public class UserDetailService implements UserDetailsService {
    @Resource
    private UserServiceImpl userServiceimpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if("".equals(username) || username == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //通过username获取用户
        MyUser user = userServiceimpl.findUserByName(username);
        //获取角色权限

        return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
                user.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
