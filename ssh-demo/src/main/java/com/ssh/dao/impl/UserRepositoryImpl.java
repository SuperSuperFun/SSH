package com.ssh.dao.impl;

import com.ssh.dao.UserRepository;
import com.ssh.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangli
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public User load(Long id) {
        //主键查询
        return (User)getSession().load(User.class, id);
    }

    @Override
    public User get(Long id) {
        //主键查询
        return (User)getSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        //HQL查询（区分大小写），查询全部
        Query query = getSession().createQuery("from User");
        return query.list();
    }

    @Override
    public void persist(User entity) {
        getSession().persist(entity);
    }

    @Override
    public Long save(User entity) {
        return (Long)getSession().save(entity);
    }

    @Override
    public void saveOrUpdate(User entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Long id) {
        //先根据主键查询对象，再判断删除
        User user = load(id);
        if (user != null) {
            getSession().delete(user);
        }
    }

    @Override
    public void flush() {
        getSession().flush();
    }
}
