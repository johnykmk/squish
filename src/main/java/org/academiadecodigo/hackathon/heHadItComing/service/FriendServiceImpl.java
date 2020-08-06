package org.academiadecodigo.hackathon.heHadItComing.service;

import org.academiadecodigo.hackathon.heHadItComing.persistence.dao.FriendDao;
import org.academiadecodigo.hackathon.heHadItComing.persistence.model.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class FriendServiceImpl implements FriendService{

    FriendDao friendDao;

    @Transactional
    @Override
    public Friend get(Integer id) {
        return friendDao.findById(id);
    }

    @Transactional
    @Override
    public Friend save(Friend friend) {
        return friendDao.saveOrUpdate(friend);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        friendDao.delete(id);
    }

    public FriendDao getFriendDao() {
        return friendDao;
    }

    @Autowired
    public void setFriendDao(FriendDao friendDao) {
        this.friendDao = friendDao;
    }
}
