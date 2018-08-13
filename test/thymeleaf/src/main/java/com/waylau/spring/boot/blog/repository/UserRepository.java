package com.waylau.spring.boot.blog.repository;

import com.waylau.spring.boot.blog.domain.User;

import java.util.List;

public interface UserRepository {

    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> listUser();
}
