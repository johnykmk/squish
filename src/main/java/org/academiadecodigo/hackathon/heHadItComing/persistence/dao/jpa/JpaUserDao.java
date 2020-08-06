package org.academiadecodigo.hackathon.heHadItComing.persistence.dao.jpa;

import org.academiadecodigo.hackathon.heHadItComing.persistence.dao.UserDao;
import org.academiadecodigo.hackathon.heHadItComing.persistence.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserDao extends GenericJpaDao<User> implements UserDao {

    public JpaUserDao () {

        super(User.class);
    }
}
