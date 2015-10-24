package com.junjunguo.tsag.dao.daoImpl;

import com.junjunguo.tsag.dao.UserDao;
import com.junjunguo.tsag.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * This file is part of tsag
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on October 11, 2015.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {

    }

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<User> findAllUsers() {
        log("find all users: ++");
        @SuppressWarnings("unchecked")
                List<User> listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
                                                                         .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                                                                         .list();

//                Collection result = new LinkedHashSet<User>(sessionFactory.getCurrentSession().createCriteria(
//                User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list());
//        log("result: ++2 ++" + result.toString());
//        @SuppressWarnings("unchecked")
//        List<User> listUser = new ArrayList<User>(result);
        log("initialize users: ");
        for (User u : listUser) {
            Hibernate.initialize(u.getTags());
        }
        log("users: " + listUser);
        return listUser;
    }

    @Transactional
    public void saveUser(User user) {
        log("save user: " + user.toString());
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        log("delete user by email");
        sessionFactory.getCurrentSession().delete(findByEmail(email));
    }

    @Transactional
    public User findByEmail(String email) {

        Query q = sessionFactory.getCurrentSession().createQuery("from User where email = '" + email + "'");
        if (q.list().isEmpty()) {
            return null;
        } else {
            User user = (User) q.list().get(0);
            Hibernate.initialize(user.getTags());
            return user;
        }
    }

    @Transactional
    public User findByName(String name) {
        Query q = sessionFactory.getCurrentSession().createQuery("from User where name = '" + name + "'");
        if (q.list().isEmpty()) {
            return null;
        } else {
            User user = (User) q.list().get(0);
            Hibernate.initialize(user.getTags());
            return user;
        }
    }

    public void log(String s) {
        System.out.print("\n----------" + this.getClass().getSimpleName() + " " + s);
    }

}
