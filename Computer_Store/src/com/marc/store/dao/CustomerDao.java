package com.marc.store.dao;

import com.marc.store.domain.Customer;

import java.util.List;

public interface CustomerDao {

    Customer findByPk(String pk);

    List<Customer> findAll();

    void create(Customer customer);

    void modify(Customer customer);

    void remove(String pk);

}
