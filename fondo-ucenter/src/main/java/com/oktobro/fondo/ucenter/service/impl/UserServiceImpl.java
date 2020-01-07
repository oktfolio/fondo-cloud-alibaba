package com.oktobro.fondo.ucenter.service.impl;

import com.oktobro.fondo.common.result.UserResultCodeEnum;
import com.oktobro.fondo.ucenter.mapper.UserMapper;
import com.oktobro.fondo.ucenter.model.SecurityUser;
import com.oktobro.fondo.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/01/07
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
//
//    private UserMapper userMapper;
//
//    @Autowired
//    public void setUserMapper(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return findByUsername(s);
    }

    public SecurityUser findByUsername(String username) {

        SecurityUser user = new SecurityUser();

        user.setUsername("oktfolio");
        user.setPassword("935395.");

        return user;
    }

}
