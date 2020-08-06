package org.academiadecodigo.hackathon.heHadItComing.service;

import org.academiadecodigo.hackathon.heHadItComing.persistence.model.Friend;

public interface FriendService {

    Friend get(Integer id);

    Friend save(Friend friend);

    void delete(Integer id);


}
