package com.marc.store.dao;

import com.marc.store.domain.Orders;

import java.util.List;

public interface OrderDao {

    Orders findByPk(String pk);

    List<Orders> findAll();

    void create(Orders orders);

    void modify(Orders orders);

    void remove(String pk);

}
