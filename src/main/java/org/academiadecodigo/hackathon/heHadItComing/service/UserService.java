package org.academiadecodigo.hackathon.heHadItComing.service;

import org.academiadecodigo.hackathon.heHadItComing.persistence.model.Friend;
import org.academiadecodigo.hackathon.heHadItComing.persistence.model.User;

import java.util.List;

public interface UserService {

    User get(Integer id);

    User add(User user);

    List<User> getUsers();

    List<Friend> getFriends(User user);

    void delete(Integer id);

    User findByUsername(String username);

}
