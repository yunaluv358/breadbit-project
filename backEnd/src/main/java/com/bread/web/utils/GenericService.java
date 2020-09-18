package com.bread.web.utils;


import java.util.Optional;

public interface GenericService<T> {
    // 공통 인터페이스 기능
    void save(T t);
    // create
    Optional<T> findById(Long id);
    Iterable<T> findAll();
    boolean exists(String id) ;
    int count();
    // read
    void delete(String id);
    // delete
}
