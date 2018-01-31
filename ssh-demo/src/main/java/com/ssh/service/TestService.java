package com.ssh.service;

import com.ssh.entity.User;

import java.util.List;

/**
 * @author wangli
 */
public interface TestService {
    Long saveUser();

    List<User> getAll();
}
