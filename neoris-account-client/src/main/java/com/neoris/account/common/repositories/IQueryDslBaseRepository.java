package com.neoris.account.common.repositories;

public interface IQueryDslBaseRepository<T> {
    void save(T entity);
    void update(T entity);
}
