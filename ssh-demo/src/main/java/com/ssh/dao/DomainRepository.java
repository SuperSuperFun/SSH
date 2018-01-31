package com.ssh.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangli
 * 该接口可以供各种实体类操作使用
 * Spring-Data-Jpa中统一了此接口
 */
public interface DomainRepository<T, PK extends Serializable> {
    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();

}

