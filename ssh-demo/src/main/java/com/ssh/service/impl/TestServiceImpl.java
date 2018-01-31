package com.ssh.service.impl;

import com.ssh.dao.UserRepository;
import com.ssh.entity.User;
import com.ssh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangli
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Long saveUser() {
        User user = new User("China", 5000);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
