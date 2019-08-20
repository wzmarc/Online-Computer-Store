package com.marc.store.dao.imp;

import com.marc.store.dao.OrderDao;
import com.marc.store.domain.Orders;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoImpJdbcTest {

    OrderDao dao;

    @BeforeEach
    void setUp() {
        dao = new OrderDaoImpJdbc();
    }

    @AfterEach
    void tearDown() {
        dao = null;
    }

    @Test
    void findByPk() {

        Orders orders = dao.findByPk("100");
        assertNotNull(orders);
        assertEquals("100", orders.getId());
        assertEquals(111111111111111L, orders.getOrderDate().getTime());
        assertEquals(1, orders.getStatus());
        assertEquals(9000, orders.getTotal());
    }

    @Test
    void findAll() {

        List<Orders> list = dao.findAll();
        assertEquals(2, list.size());

        Orders orders = list.get(1);
        assertNotNull(orders);
        assertEquals("200", orders.getId());
        assertEquals(112222222442222L, orders.getOrderDate().getTime());
        assertEquals(0, orders.getStatus());
        assertEquals(2500, orders.getTotal());
    }

    @Test
    void create() {

        Orders orders = new Orders();
        orders.setId("300");
        orders.setStatus(0);
        orders.setOrderDate(new Date(1122222224562222L));
        orders.setTotal(3560.0);

        dao.create(orders);
        Orders orders1 = dao.findByPk("300");
        assertNotNull(orders1);
        assertEquals("300", orders.getId());
        assertEquals(1122222224562222L, orders.getOrderDate().getTime());
        assertEquals(0, orders.getStatus());
        assertEquals(3560.0, orders.getTotal());

    }

    @Test
    void modify() {

        Orders orders = new Orders();
        orders.setId("300");
        orders.setStatus(1);
        orders.setOrderDate(new Date(1122234222562222L));
        orders.setTotal(900.5);

        dao.modify(orders);

        Orders orders1 = dao.findByPk("300");
        assertNotNull(orders1);
        assertEquals("300", orders.getId());
        assertEquals(1122234222562222L, orders.getOrderDate().getTime());
        assertEquals(1, orders.getStatus());
        assertEquals(900.5, orders.getTotal());

    }

    @Test
    void remove() {
        dao.remove("300");
        Orders orders = dao.findByPk("300");
        assertNull(orders);
    }
}