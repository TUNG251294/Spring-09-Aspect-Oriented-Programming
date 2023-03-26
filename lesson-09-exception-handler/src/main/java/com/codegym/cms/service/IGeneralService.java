package com.codegym.cms.service;

import com.codegym.cms.exception.DuplicateEmailException;
import com.codegym.cms.model.Customer;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t) throws DuplicateEmailException;

    void remove(Long id);
}
