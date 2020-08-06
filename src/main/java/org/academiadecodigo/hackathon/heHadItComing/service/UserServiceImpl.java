package org.academiadecodigo.hackathon.heHadItComing.service;


import org.academiadecodigo.hackathon.heHadItComing.persistence.dao.UserDao;
import org.academiadecodigo.hackathon.heHadItComing.persistence.model.Friend;
import org.academiadecodigo.hackathon.heHadItComing.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Transactional
    @Override
    public User get(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User add(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public List<Friend> getFriends(User user) {
        return userDao.findById(user.getId()).getFriends();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUser(UserDao userDao) {
        this.userDao = userDao;
    }
}
